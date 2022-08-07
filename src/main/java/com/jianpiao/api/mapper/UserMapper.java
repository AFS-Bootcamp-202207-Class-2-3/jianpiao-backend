package com.jianpiao.api.mapper;

import cn.hutool.core.bean.BeanUtil;
import com.jianpiao.api.model.dto.UserRequest;
import com.jianpiao.api.model.dto.UserResponse;
import com.jianpiao.api.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: BaBy
 * @Date: 2022/8/7 13:02
 */
@Component
public class UserMapper {
    public User toEntity(UserRequest userRequest){
        User user = new User();
        BeanUtil.copyProperties(userRequest, user);
        return user;
    }

    public UserResponse toResponse(User user){
        UserResponse userResponse = new UserResponse();
        BeanUtil.copyProperties(user, userResponse);
        return userResponse;
    }

    public List<UserResponse> toResponses(List<User> users){
        return users.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
