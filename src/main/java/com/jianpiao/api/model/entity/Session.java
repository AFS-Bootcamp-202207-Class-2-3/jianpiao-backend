package com.jianpiao.api.model.entity;

import com.jianpiao.api.model.entity.converter.StringToTimeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_session", schema = "public")
public class Session {
    @Id
    private String id;

    @Column(name = "film_id")
    private String filmId;

    @Column(name = "hall_id")
    private String hallId;

    @Column(name = "cinema_id")
    private String cinemaId;

//    @Convert(
//            converter = StringToDateConverter.class
//    )
    private Date date;

    @Column(name = "start_time")
    @Convert(
            converter = StringToTimeConverter.class
    )
    private String startTime;

    @Column(name = "end_time")
    @Convert(
            converter = StringToTimeConverter.class
    )
    private String endTime;

    private Double price;

    private String site;
}
