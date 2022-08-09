package com.jianpiao.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaResponse {

    private String id;

    private String cinemaName;

    private String address;

    private String contactNumber;
}

