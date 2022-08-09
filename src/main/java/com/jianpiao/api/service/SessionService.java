package com.jianpiao.api.service;


import com.jianpiao.api.exception.SessionNotFoundException;
import com.jianpiao.api.model.entity.Session;
import com.jianpiao.api.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public Session findById(String sessionId) {
        return sessionRepository.findById(sessionId).orElseThrow(SessionNotFoundException::new);
    }

    public Map<Date, List<Session>> findByCinemaIdAndFilmId(String cinemaId, String filmId) {

        List<Session> sessions = sessionRepository.findByCinemaIdAndFilmId(filmId, cinemaId, getCurDate(), getCurTime());

        return sessions.stream()
                .collect(Collectors.groupingBy(Session::getDate, TreeMap::new, Collectors.toList()));
    }

    private String getCurTime() {
        return Time.valueOf(LocalTime.now()).toString();
    }

    private Date getCurDate() {
        return Date.valueOf(LocalDate.now());
    }


}
