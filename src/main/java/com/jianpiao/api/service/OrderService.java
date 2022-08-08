package com.jianpiao.api.service;

import com.jianpiao.api.exception.OrderNotFoundException;
import com.jianpiao.api.model.entity.Order;
import com.jianpiao.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAllOrdersByUserId(String userId) {
        return orderRepository.findAllByUserId(userId);
    }

    public Order findById(String id) {
        return orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    public Order saveOrder(Order order) {
        order.setId(UUID.randomUUID().toString());
        return orderRepository.save(order);
    }
}
