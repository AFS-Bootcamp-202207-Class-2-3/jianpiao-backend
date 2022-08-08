package com.jianpiao.api.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderResponse {
    private Integer id;
    private Integer userId;
    private String ticket;
}
