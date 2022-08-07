package com.jianpiao.api.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import com.jianpiao.api.mapper.UserMapper;
import com.jianpiao.api.model.dto.LoginRequest;
import com.jianpiao.api.model.dto.Result;
import com.jianpiao.api.model.entity.User;
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

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest) {
        userService.login(loginRequest.getUsername(), loginRequest.getPassword());
        return Result.ok();
    }

    @GetMapping("/{userId}")
    @SaCheckLogin
    @SaCheckPermission(value = {"USER:SELECT"}, mode = SaMode.OR)
    public Result getUserById(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        return Result.ok().put("user", userMapper.toResponse(user));
    }
}
