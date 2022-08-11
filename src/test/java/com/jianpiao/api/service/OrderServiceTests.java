package com.jianpiao.api.service;


import cn.dev33.satoken.stp.StpUtil;
import com.jianpiao.api.model.entity.*;
import com.jianpiao.api.repository.FilmRepository;
import com.jianpiao.api.repository.HallRepository;
import com.jianpiao.api.repository.OrderRepository;
import com.jianpiao.api.repository.SessionRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class OrderServiceTests {

    @InjectMocks
    OrderService orderService;

    @Mock
    OrderRepository orderRepository;

    @Mock
    FilmRepository filmRepository;

    @Mock
    SessionRepository sessionRepository;

    @Mock
    HallRepository hallRepository;


    @Test
    void should_orders_when_get_orders_by_user_id_given_user_id() {
        //given
        String userId = "1";
        Date date = Date.valueOf(LocalDate.now());
        Order order = new Order(UUID.randomUUID().toString(), userId, null, date, String.valueOf(date.getTime()));

        BDDMockito.given(orderRepository.findAllByUserId(userId)).willReturn(Arrays.asList(order));

        //when
        List<Order> orders = orderService.findAllOrdersByUserId(userId);

        //then
        MatcherAssert.assertThat(orders, Matchers.hasSize(1));
    }

    @Test
    void should_order_when_get_order_by_order_id_given_order_id() {
        //given
        String orderId = UUID.randomUUID().toString();
        String userId = "1";
        Date date = Date.valueOf(LocalDate.now());
        Order order = new Order(orderId, userId, null, date, String.valueOf(date.getTime()));
        BDDMockito.given(orderRepository.findById(orderId)).willReturn(Optional.of(order));

        //when
        Order actual = orderService.findById(orderId);

        //then
        MatcherAssert.assertThat(actual, Matchers.equalTo(order));
    }

    @Test
    void should_order_when_insert_order_given_user_id_and_film_id() {
        //given
        String orderId = UUID.randomUUID().toString();
        String userId = "1";
        Date date = Date.valueOf(LocalDate.now());
        Order order = new Order(orderId, userId, null, date, String.valueOf(date.getTime()));

        Session session = new Session();
        session.setPrice(20.05);
        Hall hall = new Hall();
        hall.setId("1");
        Cinema cinema = new Cinema();
        session.setHall(hall);
        session.setFilmId("1");
        session.setCinema(cinema);
        session.setSite("1111111111111111111111111111111111111111111111111111111");
        List<Integer> seatIndexes = Arrays.asList(1);


        BDDMockito.given(orderRepository.save(BDDMockito.any())).willReturn(order);
        BDDMockito.given(sessionRepository.save(session)).willReturn(session);
        BDDMockito.given(sessionRepository.findById("1")).willReturn(Optional.of(session));
        MockedStatic<StpUtil> mockedStatic = Mockito.mockStatic(StpUtil.class);
        mockedStatic.when(StpUtil::getLoginId).thenReturn("1");
        BDDMockito.given(filmRepository.findById(session.getFilmId())).willReturn(Optional.of(new Film()));

        //when
        Order order1 = orderService.saveOrder("1", seatIndexes);

        //then
        MatcherAssert.assertThat(order1.getId(), Matchers.equalTo(orderId));
    }
}
