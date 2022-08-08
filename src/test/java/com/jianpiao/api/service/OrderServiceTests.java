package com.jianpiao.api.service;


import com.jianpiao.api.model.entity.Order;
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
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class OrderServiceTests {

    @InjectMocks
    OrderService orderService;

    @Mock
    OrderRepository orderRepository;


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
}
