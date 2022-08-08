package com.jianpiao.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.util.List;
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
    private String id;
    private String code;
    private String actionId;
    private String moduleId;

    @Transient
    private Action action;

    @Transient
    private Module module;
}
