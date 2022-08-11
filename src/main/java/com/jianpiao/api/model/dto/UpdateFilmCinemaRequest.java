package com.jianpiao.api.model.dto;

import com.jianpiao.api.model.entity.Film;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: BaBy
 * @Date: 2022/8/11 00:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFilmCinemaRequest extends Film {
    private String status;
}
