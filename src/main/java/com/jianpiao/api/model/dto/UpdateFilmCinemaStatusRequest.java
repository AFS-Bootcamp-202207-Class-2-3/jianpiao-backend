package com.jianpiao.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: BaBy
 * @Date: 2022/8/11 15:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFilmCinemaStatusRequest {
    private String filmCinemaId;
    private String status;
}