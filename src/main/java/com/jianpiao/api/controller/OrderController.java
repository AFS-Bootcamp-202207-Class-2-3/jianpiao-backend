package com.jianpiao.api.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.hutool.json.JSONUtil;
import com.jianpiao.api.mapper.OrderMapper;
import com.jianpiao.api.model.dto.OrderRequest;
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
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    @Autowired
    private FilmService filmService;


    @PostMapping
//    @SaCheckLogin
    public Result insertOrder(@RequestBody OrderRequest orderRequest) {
        return Result.ok().put("data", orderMapper.toResponse(orderService.saveOrder(orderRequest.getSessionId(), orderRequest.getSeatIndexes())));
    }

    @GetMapping("/{id}")
    public Result getOrderByOrderId(@PathVariable("id") String id) {
        return Result.ok().put("data", orderMapper.toResponse(orderService.findById(id)));
    }

}
