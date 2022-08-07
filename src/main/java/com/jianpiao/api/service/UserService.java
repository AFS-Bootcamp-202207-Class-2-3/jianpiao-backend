package com.jianpiao.api.service;

import cn.dev33.satoken.stp.StpUtil;
import com.jianpiao.api.exception.UserNotFoundException;
import com.jianpiao.api.exception.WrongLoginInfoException;
import com.jianpiao.api.model.entity.User;
import com.jianpiao.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Author: BaBy
 * @Date: 2022/8/6 18:37
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(String username, String password) {
        User loginUser = userRepository.findByUsernameAndPassword(username, password);
        if(Objects.nonNull(loginUser)){
            StpUtil.login(loginUser.getId());
        } else {
            throw new WrongLoginInfoException();
        }
        return loginUser;
    }

    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }
}
