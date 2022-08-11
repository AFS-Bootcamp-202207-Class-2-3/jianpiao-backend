package com.jianpiao.api.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;
import com.jianpiao.api.mapper.OrderMapper;
import com.jianpiao.api.model.dto.OrderRequest;
import com.jianpiao.api.model.dto.Result;
import com.jianpiao.api.service.FilmService;
import com.jianpiao.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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
    @SaCheckLogin
    public Result insertOrder(@RequestBody OrderRequest orderRequest) {
        if (Objects.isNull(orderRequest.getSeatIndexes()) || orderRequest.getSeatIndexes().size() == 0) {
            return Result.error(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return Result.ok().put("data", orderMapper.toResponse(orderService.saveOrder(orderRequest.getSessionId(), orderRequest.getSeatIndexes())));
    }

    @GetMapping("/{id}")
    public Result getOrderByOrderId(@PathVariable("id") String id) {
        return Result.ok().put("data", orderMapper.toResponse(orderService.findById(id)));
    }

}
