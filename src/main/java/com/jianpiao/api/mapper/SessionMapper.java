package com.jianpiao.api.mapper;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.jianpiao.api.model.dto.SessionResponse;
import com.jianpiao.api.model.entity.Session;
import org.springframework.stereotype.Component;

@Component
public class SessionMapper {


    public SessionResponse toResponse(Session session) {
        SessionResponse sessionResponse = new SessionResponse();
        BeanUtil.copyProperties(session, sessionResponse, CopyOptions.create().setIgnoreNullValue(true));
        return sessionResponse;
    }
}
