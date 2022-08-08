package com.jianpiao.api.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.jianpiao.api.mapper.OrderMapper;
import com.jianpiao.api.model.dto.OrderRequest;
import com.jianpiao.api.model.dto.OrderResponse;
import com.jianpiao.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderResponse> getAllOrdersByUserId() {
        return orderMapper.toResponse(orderService.findAllOrdersByUserId(StpUtil.getLoginId().toString()));
    }

//    @PostMapping
//    public OrderResponse insertOrder(@RequestBody OrderRequest orderRequest) {
//
//        orderService.saveOrder(orderRequest);
//    }

    @GetMapping("/{id}")
    public OrderResponse getOrderByOrderId(@PathVariable("id") String id) {
        return orderMapper.toResponse(orderService.findById(id));
    }

}
