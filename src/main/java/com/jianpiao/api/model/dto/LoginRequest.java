package com.jianpiao.api.model.dto;

import lombok.Data;

/**
 * @Author: BaBy
 * @Date: 2022/8/7 10:18
 */
@Data
public class LoginRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
