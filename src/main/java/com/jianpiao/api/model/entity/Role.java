package com.jianpiao.api.model.entity;

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

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch=FetchType.EAGER)
    @JoinTable(name = "role_permission",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")}
    )
    private Set<Permission> permissions;

    public List<Permission> getPermissions(){
        return new ArrayList<>(permissions);
    }

    public String getRoleName() {
        return roleName;
    }
}