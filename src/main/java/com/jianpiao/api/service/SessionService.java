package com.jianpiao.api.service;


import com.jianpiao.api.exception.SessionNotFoundException;
import com.jianpiao.api.model.entity.Session;
import com.jianpiao.api.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public Session findById(String sessionId) {
        return sessionRepository.findById(sessionId).orElseThrow(SessionNotFoundException::new);
    }
}
