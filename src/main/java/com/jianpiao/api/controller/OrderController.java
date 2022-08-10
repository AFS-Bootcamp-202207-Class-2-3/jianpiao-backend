package com.jianpiao.api.controller;


import com.jianpiao.api.mapper.OrderMapper;
import com.jianpiao.api.model.dto.OrderRequest;
import com.jianpiao.api.model.dto.Result;
import com.jianpiao.api.model.entity.Order;
import com.jianpiao.api.service.FilmService;
import com.jianpiao.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result insertOrder(@RequestBody OrderRequest orderRequest) {
        Order order = orderMapper.toEntity(orderRequest);
        return Result.ok().put("data", orderMapper.toResponse(orderService.saveOrder(order, orderRequest.getFilmId())));
    }

    @GetMapping("/{id}")
    public Result getOrderByOrderId(@PathVariable("id") String id) {
        return Result.ok().put("data", orderMapper.toResponse(orderService.findById(id)));
    }

}
