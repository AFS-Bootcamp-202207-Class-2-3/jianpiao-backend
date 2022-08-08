package com.jianpiao.api.config;

/**
 * @Author: BaBy
 * @Date: 2022/8/7 10:21
 */

import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.json.JSONUtil;
import com.jianpiao.api.exception.UserNotFoundException;
import com.jianpiao.api.model.entity.Permission;
import com.jianpiao.api.model.entity.Role;
import com.jianpiao.api.model.entity.User;
import com.jianpiao.api.repository.RoleRepository;
import com.jianpiao.api.repository.UserRepository;
import com.jianpiao.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 自定义权限验证接口扩展
 */
@Component
public class SaCustomizePermissionAuthentication implements StpInterface {

    @Autowired
    private UserService userService;

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    @Transactional
    public List<String> getPermissionList(Object loginId, String loginType) {
        return userService.getPermissionsByUser(loginId.toString()).stream()
                .map(Permission::getCode)
                .collect(Collectors.toList());
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    @Transactional
    public List<String> getRoleList(Object loginId, String loginType) {
        return userService.getRolesByUser(loginId.toString()).stream()
                .map(Role::getRoleName)
                .collect(Collectors.toList());
    }
}
