package com.jianpiao.api.config;

/**
 * @Author: BaBy
 * @Date: 2022/8/7 10:21
 */

import cn.dev33.satoken.stp.StpInterface;
import com.jianpiao.api.exception.UserNotFoundException;
import com.jianpiao.api.model.entity.Permission;
import com.jianpiao.api.model.entity.Role;
import com.jianpiao.api.model.entity.User;
import com.jianpiao.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义权限验证接口扩展
 */
@Component
public class SaCustomizePermissionAuthentication implements StpInterface {

    @Autowired
    private UserRepository userRepository;

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        User user = userRepository.findById(loginId.toString()).orElseThrow(UserNotFoundException::new);
        List<String> permissions = user.getRoles().stream()
                .map(Role::getPermissions)
                .flatMap(List::stream)
                .distinct()
                .map(Permission::getCode)
                .collect(Collectors.toList());
        return permissions;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        User user = userRepository.findById(loginId.toString()).orElseThrow(UserNotFoundException::new);
        return user.getRoles().stream()
                .map(Role::getRoleName)
                .collect(Collectors.toList());
    }
}
