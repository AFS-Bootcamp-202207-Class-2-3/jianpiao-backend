package com.jianpiao.api.service;


import cn.dev33.satoken.stp.StpUtil;
import com.jianpiao.api.model.entity.Order;
import com.jianpiao.api.repository.FilmRepository;
import com.jianpiao.api.repository.HallRepository;
import com.jianpiao.api.repository.OrderRepository;
import com.jianpiao.api.repository.SessionRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
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

    @Mock
    StpUtil stpUtil;


    @Test
    void should_orders_when_get_orders_by_user_id_given_user_id() {

        //given
        String userId = "1";
        Order order = new Order(UUID.randomUUID().toString(), userId, null);

        BDDMockito.given(orderRepository.findAllByUserId(userId)).willReturn(Collections.singletonList(order));

        //when
        List<Order> orders = orderService.findAllOrdersByUserId(userId);

        //then
        MatcherAssert.assertThat(orders, Matchers.hasSize(1));
    }

    @Test
    void should_order_when_get_order_by_order_id_given_order_id() {
        //given
        String orderId = UUID.randomUUID().toString();
        Order order = new Order(orderId, null, null);
        BDDMockito.given(orderRepository.findById(orderId)).willReturn(Optional.of(order));

        //when
        Order actual = orderService.findById(orderId);

        //then
        MatcherAssert.assertThat(actual, Matchers.equalTo(order));
    }

//    @Test
//    void should_order_when_insert_order_given_user_id_and_film_id() {
//        //given
//        String orderId = "1";
//        Order order = new Order(orderId, null, null);
//        Session session = new Session();
//        Hall hall = new Hall();
//        hall.setId("1");
//        session.setHall(hall);
//        session.setFilmId("1");
//        session.setSite("1111111111111111111111111111111111111111111111111111111");
//        List<Integer> seatIndexes = Arrays.asList(1);
//
//        BDDMockito.given(orderRepository.save(order)).willReturn(order);
//        BDDMockito.given(sessionRepository.save(session)).willReturn(session);
//        BDDMockito.given(sessionRepository.findById("1")).willReturn(Optional.of(session));
//        BDDMockito.given(StpUtil.getLoginId()).willReturn("1");
//        BDDMockito.given(hallRepository.findById(session.getHall().getId())).willReturn(Optional.of(hall));
//        BDDMockito.given(filmRepository.findById(session.getFilmId())).willReturn(Optional.of(new Film()));
//
//        //when
//        Order order1 = orderService.saveOrder("1", seatIndexes);
//
//        //then
//        MatcherAssert.assertThat(order1.getId(), Matchers.not(orderId));
//    }
}
