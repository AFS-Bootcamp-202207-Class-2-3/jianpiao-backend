package com.jianpiao.api.service;


import com.jianpiao.api.model.entity.Film;
import com.jianpiao.api.model.entity.Order;
import com.jianpiao.api.repository.FilmRepository;
import com.jianpiao.api.repository.OrderRepository;
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

    @Test
    void should_order_when_insert_order_given_user_id_and_film_id() {
        //given
        String orderId = "1";
        Order order = new Order(orderId, null, null);
        BDDMockito.given(orderRepository.save(order)).willReturn(order);
        BDDMockito.given(filmRepository.findById("1")).willReturn(Optional.of(new Film()));

        //when
        Order order1 = orderService.saveOrder(order, "1");

        //then
        MatcherAssert.assertThat(order1.getId(), Matchers.not(orderId));
    }
}
