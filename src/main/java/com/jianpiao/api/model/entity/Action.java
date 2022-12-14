package com.jianpiao.api.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: BaBy
 * @Date: 2022/8/6 18:09
 */
@Data
@Entity
@Table(name = "tb_action")
public class Action {
    @Id
    private String id;
    private String code;
    private String name;
}
