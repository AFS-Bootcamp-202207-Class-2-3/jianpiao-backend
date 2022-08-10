package com.jianpiao.api.model.dto;

import com.jianpiao.api.model.entity.Permission;
import com.jianpiao.api.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * @Author: BaBy
 * @Date: 2022/8/7 10:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String id;
    private String username;
    private String nickname;
    private String photo;
    private String name;
    private String gender;
    private String tel;
    private String email;
    private List<String> roles;
    private List<String> permissions;
}
