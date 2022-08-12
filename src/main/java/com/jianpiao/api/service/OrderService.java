package com.jianpiao.api.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONUtil;
import com.jianpiao.api.exception.FilmNotFoundException;
import com.jianpiao.api.exception.OrderNotFoundException;
import com.jianpiao.api.exception.SessionNotFoundException;
import com.jianpiao.api.model.entity.Cinema;
import com.jianpiao.api.model.entity.Film;
import com.jianpiao.api.model.entity.Order;
import com.jianpiao.api.model.entity.Session;
import com.jianpiao.api.repository.FilmRepository;
import com.jianpiao.api.repository.OrderRepository;
import com.jianpiao.api.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private SessionRepository sessionRepository;

    public List<Order> findAllOrdersByUserId(String userId) {
        return orderRepository.findAllByUserId(userId);
    }

    public Order findById(String id) {
        return orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    @Transactional
    public synchronized Order saveOrder(String sessionId, List<Integer> seatIndexes) {
        Session session = sessionRepository.findById(sessionId).orElseThrow(SessionNotFoundException::new);
        Film film = filmRepository.findById(session.getFilm().getId()).orElseThrow(FilmNotFoundException::new);
        String hallName = session.getHall().getName();
        Cinema cinema = session.getCinema();

        Map<String, Object> map = getTicketMap(seatIndexes, session, film, hallName, cinema);
        String createTime = getCurDate();

        Order order = new Order(UUID.randomUUID().toString(),
                StpUtil.getLoginId().toString(), JSONUtil.parse(map).toString(), createTime, String.valueOf(new Date().getTime()));


        sessionRepository.save(session);
        return orderRepository.save(order);
    }

    private Map<String, Object> getTicketMap(List<Integer> seatIndexes, Session session, Film film, String hallName, Cinema cinema) {
        Map<String, Object> map = new HashMap();
        map.put("filmId", film.getId());
        map.put("filmName", film.getFilmName());
        map.put("posterUrl", film.getPosterUrl());

        map.put("totalPrice", toPrice(session.getPrice(), seatIndexes.size()));

        map.put("hallName", hallName);
        map.put("seat", session.updateSite(seatIndexes, Session.SOLD));
        map.put("date", session.getDate() + " " + session.getStartTime());

        map.put("cinemaName", cinema.getCinemaName());
        map.put("contactNumber", cinema.getContactNumber());
        return map;
    }

    private String toPrice(Double price, int size) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return decimalFormat.format(price * size);
    }

    private String getCurDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GTM+8");
        TimeZone.setDefault(timeZone);
        return simpleDateFormat.format(new Date());
    }
}
