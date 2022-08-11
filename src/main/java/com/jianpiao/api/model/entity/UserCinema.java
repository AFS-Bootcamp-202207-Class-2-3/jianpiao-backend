package com.jianpiao.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: BaBy
 * @Date: 2022/8/10 22:14
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_cinema")
public class UserCinema {
    @Id
    private String id;
    private String userId;
    private String cinemaId;
}
