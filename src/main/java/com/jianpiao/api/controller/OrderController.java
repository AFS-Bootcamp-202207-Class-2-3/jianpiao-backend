package com.jianpiao.api.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.jianpiao.api.mapper.OrderMapper;
import com.jianpiao.api.model.dto.OrderResponse;
import com.jianpiao.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderService orderService;

    @GetMapping()
    public List<OrderResponse> getAllOrdersByUserId() {
        return orderMapper.toResponse(orderService.findAllOrdersByUserId(StpUtil.getLoginId().toString()));
    }

}
