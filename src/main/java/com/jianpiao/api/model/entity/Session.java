package com.jianpiao.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_session   ", schema = "public")
public class Session {
    @Id
    private String id;

    @Column(name = "film_id")
    private String filmId;

    @Column(name = "hall_id")
    private String hallId;

    @Column(name = "cinema_id")
    private String cinemaId;

    private Date date;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    private Double price;

    private String site;
}
