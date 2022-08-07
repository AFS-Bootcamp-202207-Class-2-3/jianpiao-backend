package com.jianpiao.api.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: BaBy
 * @Date: 2022/8/6 17:51
 */
@Data
@Entity
@Table(name = "tb_module")
public class Module {
    @Id
    private String id;
    private String code;
    private String name;
    @OneToOne(mappedBy = "module")
    private Permission permission;

    public String getCode() {
        return code;
    }
}
