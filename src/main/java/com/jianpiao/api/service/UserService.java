package com.jianpiao.api.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.json.JSONUtil;
import com.jianpiao.api.exception.UserNotFoundException;
import com.jianpiao.api.exception.WrongLoginInfoException;
import com.jianpiao.api.exception.WrongRegisterInfoException;
import com.jianpiao.api.model.entity.Permission;
import com.jianpiao.api.model.entity.Role;
import com.jianpiao.api.model.entity.User;
import com.jianpiao.api.repository.PermissionRepository;
import com.jianpiao.api.repository.RoleRepository;
import com.jianpiao.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: BaBy
 * @Date: 2022/8/6 18:37
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    public User login(String username, String password) {
        User loginUser = userRepository.findByUsernameAndPassword(username, password);
        if (Objects.nonNull(loginUser)) {
            StpUtil.login(loginUser.getId());
        } else {
            throw new WrongLoginInfoException();
        }
        return loginUser;
    }

    @Transactional
    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    public User register(User user) {
        user.setId(UUID.randomUUID().toString());
        if (Objects.isNull(user.getUsername()) || Objects.isNull(user.getPassword())) {
            throw new WrongRegisterInfoException("username or password is null");
        }
        if (Objects.nonNull(userRepository.findByUsername(user.getUsername()))) {
            throw new WrongRegisterInfoException("username already exists");
        }
        User savedUser = userRepository.save(user);
        StpUtil.login(savedUser.getId());
        return savedUser;
    }

    public List<Role> getRolesByUser(String id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        List<String> roleIds = JSONUtil.parseArray(user.getRoleIds()).stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        return roleRepository.findAllById(roleIds);
    }

    public List<Permission> getPermissionsByUser(String id) {
        List<Role> roles = getRolesByUser(id);

        Set<Permission> permissionSet = new HashSet<>();
        roles.forEach(role -> {
            List<String> permissionIds = JSONUtil.parseArray(role.getPermissionIds()).stream()
                    .map(Object::toString)
                    .collect(Collectors.toList());
            permissionSet.addAll(permissionRepository.findAllById(permissionIds));
        });
        return new ArrayList<>(permissionSet);
    }

    public User updateUser(String id, User user) {
        User existedUser = getUserById(id);
        if (user.getPassword().equals("")) {
            user.setPassword(null);
        }
        BeanUtil.copyProperties(user, existedUser, CopyOptions.create().setIgnoreNullValue(true));

        return userRepository.save(existedUser);
    }
}
