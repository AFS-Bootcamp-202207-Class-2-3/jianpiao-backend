package com.jianpiao.api.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONUtil;
import com.jianpiao.api.exception.*;
import com.jianpiao.api.model.entity.Cinema;
import com.jianpiao.api.model.entity.Film;
import com.jianpiao.api.model.entity.Order;
import com.jianpiao.api.model.entity.Session;
import com.jianpiao.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private HallRepository hallRepository;

    public List<Order> findAllOrdersByUserId(String userId) {
        return orderRepository.findAllByUserId(userId);
    }

    public Order findById(String id) {
        return orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    @Transactional
    public Order saveOrder(String sessionId, List<Integer> seatIndexes) {
        Session session = sessionRepository.findById(sessionId).orElseThrow(SessionNotFoundException::new);
        Film film = filmRepository.findById(session.getFilmId()).orElseThrow(FilmNotFoundException::new);
        String hallName = hallRepository.findById(session.getHall().getId()).orElseThrow(HallNotFoundException::new).getName();
        Cinema cinema = cinemaRepository.findById(session.getCinema().getId()).orElseThrow(() -> new CinemaException(CinemaException.CINEMA_NOT_FOUND));

        Map<String, Object> map = new HashMap();
        map.put("filmName", film.getFilmName());
        map.put("hallName", hallName);
        map.put("seat", session.updateSite(seatIndexes, Session.SOLD));
        map.put("date", session.getDate() + " " + session.getStartTime());
        map.put("price", toPrice(session.getPrice(), seatIndexes.size()));
        map.put("posterUrl", film.getPosterUrl());
        map.put("cinemaName", cinema.getCinemaName());


        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setUserId(StpUtil.getLoginId().toString());
        order.setTicket(JSONUtil.parse(map).toString());
        order.setCreateTime(getCurDate());
        order.setCode(String.valueOf(order.getCreateTime().getTime()));


        sessionRepository.save(session);
        return orderRepository.save(order);
    }

    private String toPrice(Double price, int size) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return decimalFormat.format(price * size);
    }

    private Date getCurDate() {
        return Date.valueOf(LocalDate.now());
    }
}
