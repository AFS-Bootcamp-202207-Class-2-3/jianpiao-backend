package com.jianpiao.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_hall", schema = "public")
public class Hall {

    @Id
    private String id;

    @Column(name = "cinema_id")
    private String cinemaId;

    private String name;

    @Column(name = "x_size")
    private String XSize;

    private String site;
}
