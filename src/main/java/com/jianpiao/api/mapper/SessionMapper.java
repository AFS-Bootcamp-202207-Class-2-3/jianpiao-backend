package com.jianpiao.api.mapper;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.jianpiao.api.model.dto.SessionResponse;
import com.jianpiao.api.model.entity.Session;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class SessionMapper {


    public SessionResponse toResponse(Session session) {
        SessionResponse sessionResponse = new SessionResponse();
        BeanUtil.copyProperties(session, sessionResponse, CopyOptions.create().setIgnoreNullValue(true));
        return sessionResponse;
    }

    public Object toResponse(Map<Date, List<Session>> sessions) {
        return sessions.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry-> entry.getKey().toString(),
                        entry -> entry.getValue().stream().map(this::toResponse).collect(Collectors.toList()),
                        (oldVal, newVal) -> newVal,
                        TreeMap::new
                ));
    }
}
