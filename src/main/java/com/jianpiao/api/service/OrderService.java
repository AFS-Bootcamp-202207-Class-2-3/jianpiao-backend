package com.jianpiao.api.service;

import cn.hutool.json.JSONUtil;
import com.jianpiao.api.exception.FilmNotFoundException;
import com.jianpiao.api.exception.OrderNotFoundException;
import com.jianpiao.api.model.entity.Film;
import com.jianpiao.api.model.entity.Order;
import com.jianpiao.api.repository.FilmRepository;
import com.jianpiao.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private FilmRepository filmRepository;

    public List<Order> findAllOrdersByUserId(String userId) {
        return orderRepository.findAllByUserId(userId);
    }

    public Order findById(String id) {
        return orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    public Order saveOrder(Order order, String filmId) {
        Film film = filmRepository.findById(filmId).orElseThrow(FilmNotFoundException::new);

        Map<String, Object> map = new HashMap();
        map.put("filmName", film.getFilmName());
        map.put("posterUrl", film.getPosterUrl());
        map.put("totalPrice", Math.random() * 100);
        String json = JSONUtil.parse(map).toString();
        order.setTicket(json);

        order.setId(UUID.randomUUID().toString());
        return orderRepository.save(order);
    }
}
