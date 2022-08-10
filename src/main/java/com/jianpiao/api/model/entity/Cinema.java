package com.jianpiao.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cinema", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cinema {

    @Id
    private String id;

    private String cinemaName;

    private String address;

    private String contactNumber;
}
