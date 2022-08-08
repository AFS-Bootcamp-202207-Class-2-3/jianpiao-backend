package com.jianpiao.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: BaBy
 * @Date: 2022/8/6 17:16
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_user")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String nickname;
    private String photo;
    private String name;
    private String gender;
    private String tel;
    private String email;
    private String roleIds;

    @Transient
    private List<Role> roles;
}
