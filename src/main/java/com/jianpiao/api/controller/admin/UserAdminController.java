package com.jianpiao.api.controller.admin;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONUtil;
import com.jianpiao.api.mapper.UserMapper;
import com.jianpiao.api.model.dto.Result;
import com.jianpiao.api.model.dto.UserAdminRegisterRequest;
import com.jianpiao.api.model.dto.UserRequest;
import com.jianpiao.api.model.dto.UserResponse;
import com.jianpiao.api.model.entity.User;
import com.jianpiao.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author: BaBy
 * @Date: 2022/8/11 13:54
 */
@RestController("/admin/users")
public class UserAdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/register")
    public Result register(@RequestBody UserAdminRegisterRequest request) {
        User user = userService.adminRegister(request.getUsername(), request.getPassword(), request.getInvitationCode());
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            UserResponse userResponse = userMapper.toResponse(user);
            userResponse.setRoles(StpUtil.getRoleList());
            userResponse.setPermissions(StpUtil.getPermissionList());
            put("userInfo", userResponse);
        }};
        return Result.ok().put("data", data);
    }
}
