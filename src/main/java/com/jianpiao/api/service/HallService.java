package com.jianpiao.api.service;

import com.jianpiao.api.model.entity.Hall;
import com.jianpiao.api.repository.HallRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Berlin
 * @Date: 2022/8/10 13:44
 */
@Service
public class HallService {

    private HallRepository hallRepository;

    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    public List<Hall> getAllHalls() {
        // TODO:获取当前登陆的管理员，所归属的影院id，替换下面cinemaId
        String cinemaId = "1";
        return hallRepository.findByCinemaId(cinemaId);
    }

}
