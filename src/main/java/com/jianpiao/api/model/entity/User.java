package com.jianpiao.api.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String photo;
    private String name;
    private String gender;
    private String tel;
    private String email;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
        )
    private Set<Role> roles;
}
