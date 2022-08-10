package com.jianpiao.api.service;

import cn.hutool.json.JSONUtil;
import com.jianpiao.api.exception.FilmNotFoundException;
import com.jianpiao.api.exception.HallNotFoundException;
import com.jianpiao.api.exception.OrderNotFoundException;
import com.jianpiao.api.exception.SessionNotFoundException;
import com.jianpiao.api.model.entity.Order;
import com.jianpiao.api.model.entity.Session;
import com.jianpiao.api.repository.FilmRepository;
import com.jianpiao.api.repository.HallRepository;
import com.jianpiao.api.repository.OrderRepository;
import com.jianpiao.api.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        String filmName = filmRepository.findById(session.getFilmId()).orElseThrow(FilmNotFoundException::new).getFilmName();
        String hallName = hallRepository.findById(session.getHall().getId()).orElseThrow(HallNotFoundException::new).getName();

        Map<String, Object> map = new HashMap();
        map.put("fileName", filmName);
        map.put("hallName", hallName);
        map.put("seat", session.updateSite(seatIndexes, Session.SOLD));
        map.put("date", session.getDate() + " " + session.getStartTime());
        map.put("price", session.getPrice());

        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
//        order.setUserId(StpUtil.getLoginId().toString());
        order.setUserId("1");
        order.setTicket(JSONUtil.parse(map).toString());

        sessionRepository.save(session);
        return orderRepository.save(order);
    }
}
