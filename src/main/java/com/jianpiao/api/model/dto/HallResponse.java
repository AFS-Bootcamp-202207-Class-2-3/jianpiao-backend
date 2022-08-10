package com.jianpiao.api.model.dto;

import lombok.Data;

/**
 * @Author: Berlin
 * @Date: 2022/8/10 13:44
 */
@Data
public class HallResponse {

    private String id;
    private String name;

    public HallResponse() {
    }

    public HallResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
