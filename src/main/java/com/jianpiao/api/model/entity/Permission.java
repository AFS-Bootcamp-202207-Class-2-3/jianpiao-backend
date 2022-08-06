package com.jianpiao.api.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

/**
 * @Author: BaBy
 * @Date: 2022/8/6 17:46
 */
@Data
@Entity
@Table(name = "tb_permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "action_id", referencedColumnName = "id")
    private Action action;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "module_id", referencedColumnName = "id")
    private Module module;

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;
}
