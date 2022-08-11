package com.jianpiao.api.service;


import cn.dev33.satoken.stp.StpUtil;
import com.jianpiao.api.exception.SessionException;
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

    public Map<Date, List<Session>> findSessions(String cinemaId, String filmId, boolean needOrderByDate) {
        Specification specification = new FindSessionSpecification(cinemaId, filmId, getCurDate(), getCurTime(), needOrderByDate);
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
        if (toSaveSession.getEndTime().compareTo(toSaveSession.getStartTime()) <= 0) {
            throw new SessionException(SessionException.END_TIME_LESS_THAN_START_TIME);
        }

        List<Session> sessions = sessionRepository.findAllByDate(toSaveSession.getDate());
        if (ifTimeConflict(sessions, toSaveSession)) {
            throw new SessionException(SessionException.TIME_CONFLICT);
        }

        toSaveSession.setId(UUID.randomUUID().toString());
        toSaveSession.setSite(initSite());
        return sessionRepository.save(toSaveSession);
    }

    private boolean ifTimeConflict(List<Session> sessions, Session toSaveSession) {
        List<Session> sameCinemaAndHall = sessions.stream()
                .filter(session -> session.getHall().getId().equals(toSaveSession.getHall().getId()))
                .filter(session -> session.getCinema().getId().equals(toSaveSession.getCinema().getId()))
                .collect(Collectors.toList());

        for (Session session : sameCinemaAndHall) {
            //开始时间相同，冲突
            if (session.getStartTime().equals(toSaveSession.getStartTime())) {
                return true;
            }
            //开始时间大于已有的开始时间 且 开始时间小于已有的结束时间, 冲突
            else if (session.getStartTime().compareTo(toSaveSession.getStartTime()) < 0
                    && session.getEndTime().compareTo(toSaveSession.getStartTime()) > 0) {
                return true;
            }
            //开始时间小于已有的开始时间，且结束时间大于已有的开始时间，冲突
            else if (toSaveSession.getStartTime().compareTo(session.getStartTime()) < 0
                    && toSaveSession.getEndTime().compareTo(session.getStartTime()) > 0) {
                return true;
            }
        }
        return false;
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
