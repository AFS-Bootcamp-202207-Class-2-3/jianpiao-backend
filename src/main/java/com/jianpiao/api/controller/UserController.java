package com.jianpiao.api.controller;

import com.jianpiao.api.model.dto.LoginRequest;
import com.jianpiao.api.model.dto.Result;
import com.jianpiao.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: BaBy
 * @Date: 2022/8/6 23:44
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest) {
        userService.login(loginRequest.getUsername(), loginRequest.getPassword());
        return Result.ok();
    }
}
