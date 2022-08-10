package com.jianpiao.api.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.stp.StpUtil;
import com.jianpiao.api.mapper.OrderMapper;
import com.jianpiao.api.mapper.UserMapper;
import com.jianpiao.api.model.dto.LoginRequest;
import com.jianpiao.api.model.dto.Result;
import com.jianpiao.api.model.dto.UserRequest;
import com.jianpiao.api.model.entity.User;
import com.jianpiao.api.service.OrderService;
import com.jianpiao.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest) {
        User user = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
        HashMap<String, Object> data = new HashMap<String, Object>(){{
            put("user", userMapper.toResponse(user));
            put("roles", StpUtil.getRoleList());
            put("permissions", StpUtil.getPermissionList());
        }};
        return Result.ok().put("data", data);
    }

    @GetMapping("/{userId}")
    @SaCheckLogin
    @SaCheckPermission(value = {"USER:SELECT"}, mode = SaMode.OR)
    public Result getUserById(@PathVariable String userId) {
        User user = userService.getUserById(userId);
        return Result.ok().put("user", userMapper.toResponse(user));
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserRequest userRequest) {
        User user = userService.register(userMapper.toEntity(userRequest));
        HashMap<String, Object> data = new HashMap<String, Object>(){{
            put("user", userMapper.toResponse(user));
            put("roles", StpUtil.getRoleList());
            put("permissions", StpUtil.getPermissionList());
        }};
        return Result.ok().put("data", data);
    }

    @GetMapping("/{userId}/orders")
    public Result getAllOrdersByUserId(@PathVariable String userId) {
        //todo
        return Result.ok().put("data", orderMapper.toResponse(orderService.findAllOrdersByUserId(userId)));
    }
}
