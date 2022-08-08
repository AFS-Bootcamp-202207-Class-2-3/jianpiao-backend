package com.jianpiao.api.mapper;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.jianpiao.api.model.dto.OrderResponse;
import com.jianpiao.api.model.entity.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {


    public List<OrderResponse> toResponse(List<Order> orders) {
        return orders.stream()
                .map(order -> toResponse(order))
                .collect(Collectors.toList());
    }

    public OrderResponse toResponse(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        BeanUtil.copyProperties(order, orderResponse, CopyOptions.create().setIgnoreNullValue(true));
        return orderResponse;
    }
}
