package com.jianpiao.api.service;

import com.jianpiao.api.model.entity.Hall;
import com.jianpiao.api.repository.HallRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public Hall addHall(String hallName) {
        // TODO:获取当前登陆的管理员，所归属的影院id，替换下面cinemaId及XSize，Site
        String cinemaId = "1";
        String XSize = "11";
        String site = "11111111111111111111111111111111111111111111111111111111111111111111111111111";

        Hall hall = new Hall();
        hall.setId(UUID.randomUUID().toString());
        hall.setCinemaId(cinemaId);
        hall.setName(hallName);
        hall.setXSize(XSize);
        hall.setSite(site);
        return hallRepository.save(hall);
    }
}
