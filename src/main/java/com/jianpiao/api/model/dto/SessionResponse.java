package com.jianpiao.api.model.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.ZoneId;
import java.util.TimeZone;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionResponse {

    private String id;

    private String filmId;

    private String hallId;

    private String cinemaId;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;

    private String startTime;

    private String endTime;

    private Double price;

    private String site;
}
