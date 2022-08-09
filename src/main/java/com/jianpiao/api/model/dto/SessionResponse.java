package com.jianpiao.api.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionResponse {

    private String id;

    private String filmId;

    private String hallId;

    private String cinemaId;

    private Date date;

    private String startTime;

    private String endTime;

    private Double price;

    private String seat;

    private String site;
}
