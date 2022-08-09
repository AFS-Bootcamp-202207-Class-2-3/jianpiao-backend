package com.jianpiao.api.controller;


import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONUtil;
import com.jianpiao.api.mapper.OrderMapper;
import com.jianpiao.api.model.dto.OrderRequest;
import com.jianpiao.api.model.dto.OrderResponse;
import com.jianpiao.api.model.dto.Result;
import com.jianpiao.api.model.entity.Film;
import com.jianpiao.api.model.entity.Order;
import com.jianpiao.api.service.FilmService;
import com.jianpiao.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    @Autowired
    private FilmService filmService;

    @GetMapping
    public Result getAllOrdersByUserId() {
        return Result.ok().put("data", orderMapper.toResponse(orderService.findAllOrdersByUserId(StpUtil.getLoginId().toString())));
    }

    @PostMapping
    public Result insertOrder(@RequestBody OrderRequest orderRequest) {
        Order order = orderMapper.toEntity(orderRequest);
        Film film = filmService.findFilmById(orderRequest.getFilmId());

        Map<String, Object> map = new HashMap();
        map.put("filmName", film.getFilmName());
        map.put("posterUrl", film.getPosterUrl());
        map.put("totalPrice", Math.random()*100);
        String json = JSONUtil.parse(map).toString();
        order.setTicket(json);

        return Result.ok().put("data", orderMapper.toResponse(orderService.saveOrder(order)));
    }

    @GetMapping("/{id}")
    public Result getOrderByOrderId(@PathVariable("id") String id) {
        return Result.ok().put("data", orderMapper.toResponse(orderService.findById(id)));
    }

}
