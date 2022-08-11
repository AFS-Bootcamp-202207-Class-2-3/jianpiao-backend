package com.jianpiao.api.service;


import cn.dev33.satoken.stp.StpUtil;
import com.jianpiao.api.exception.SessionNotFoundException;
import com.jianpiao.api.exception.UnAuthorizedException;
import com.jianpiao.api.model.entity.Session;
import com.jianpiao.api.model.entity.UserCinema;
import com.jianpiao.api.repository.SessionRepository;
import com.jianpiao.api.repository.UserCinemaRepository;
import com.jianpiao.api.service.specification.FindSessionSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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

    @Autowired
    private UserCinemaRepository userCinemaRepository;

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

    public Session saveSession(Session toSaveSession) {
        toSaveSession.setId(UUID.randomUUID().toString());
        toSaveSession.setSite(initSite());
        return sessionRepository.save(toSaveSession);
    }

    public void deleteSession(String sessionId) {
        Session session = findById(sessionId);

        if (!hasPermission(session)) {
            throw new UnAuthorizedException(UnAuthorizedException.DO_NOT_HAVE_DELETE_AUTHORIZATION);
        }
        sessionRepository.deleteById(sessionId);
    }

    private boolean hasPermission(Session session) {
        String userId = StpUtil.getLoginId().toString();
        List<UserCinema> cinemas = userCinemaRepository.findAllByUserId(userId);
        return cinemas.stream()
                .anyMatch(cinema -> cinema.getCinemaId().equals(session.getCinema().getId()));
    }

    private String initSite() {
        //todo 目前是固定
        int row = 7;
        int col = 11;
        char[] chars = new char[row * col];
        Arrays.fill(chars, '1');
        return new String(chars);
    }
}
