package com.jianpiao.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "tb_role")
public class Role {
    @Id
    private String id;
    private String roleName;
    private String permissionIds;

    @Transient
    private List<Permission> permissions;
}