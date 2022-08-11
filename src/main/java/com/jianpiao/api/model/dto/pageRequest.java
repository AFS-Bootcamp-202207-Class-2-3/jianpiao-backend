package com.jianpiao.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: BaBy
 * @Date: 2022/8/10 20:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class pageRequest {
    // 第一页开始
    private Integer start;
    private Integer size;
}
