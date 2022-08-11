package com.jianpiao.api.service;

import cn.dev33.satoken.stp.StpUtil;
import com.jianpiao.api.model.entity.Hall;
import com.jianpiao.api.model.entity.UserCinema;
import com.jianpiao.api.repository.HallRepository;
import com.jianpiao.api.repository.UserCinemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Author: Berlin
 * @Date: 2022/8/10 13:44
 */
@Service
public class HallService {

    public static final String HALL_XSITE = "11";

    public static final String HALL_SITE = "11111111111111111111111111111111111111111111111111111111111111111111111111111";

    private HallRepository hallRepository;

    private UserCinemaRepository userCinemaRepository;

    public HallService(HallRepository hallRepository, UserCinemaRepository userCinemaRepository) {
        this.hallRepository = hallRepository;
        this.userCinemaRepository = userCinemaRepository;
    }

    public List<Hall> getAllHalls() {
        String userId = StpUtil.getLoginId().toString();
        UserCinema userCinema = userCinemaRepository.findAllByUserId(userId).stream().findFirst().get();

        return hallRepository.findByCinemaId(userCinema.getCinemaId());
    }

    public Hall addHall(String hallName) {
        String userId = StpUtil.getLoginId().toString();
        UserCinema userCinema = userCinemaRepository.findAllByUserId(userId).stream().findFirst().get();

        String cinemaId = userCinema.getCinemaId();

        Hall hall = new Hall();
        hall.setId(UUID.randomUUID().toString());
        hall.setCinemaId(cinemaId);
        hall.setName(hallName);
        hall.setXSize(HALL_XSITE);
        hall.setSite(HALL_SITE);
        return hallRepository.save(hall);
    }
}
