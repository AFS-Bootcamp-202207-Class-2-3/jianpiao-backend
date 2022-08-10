package com.jianpiao.api.service;


import com.jianpiao.api.exception.SessionNotFoundException;
import com.jianpiao.api.model.entity.Session;
import com.jianpiao.api.repository.SessionRepository;
import com.jianpiao.api.service.specification.FindSessionSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public Session findById(String sessionId) {
        return sessionRepository.findById(sessionId).orElseThrow(SessionNotFoundException::new);
    }

    public Map<Date, List<Session>> findSessions(String cinemaId, String filmId) {
        Specification specification = new FindSessionSpecification(cinemaId, filmId, getCurDate(), getCurTime());
        List<Session> sessions = sessionRepository.findAll(specification);

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
