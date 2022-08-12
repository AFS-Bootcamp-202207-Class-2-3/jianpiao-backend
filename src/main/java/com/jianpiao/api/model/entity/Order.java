package com.jianpiao.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_order", schema = "public")
public class Order {

    @Id
    private String id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    private String ticket;

    @Column(name = "create_time")
    private String createTime;

    private String code;
}
