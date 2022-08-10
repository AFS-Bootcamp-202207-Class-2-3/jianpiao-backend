package com.jianpiao.api.mapper;

import com.jianpiao.api.model.dto.HallResponse;
import com.jianpiao.api.model.entity.Hall;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HallMapper {

    public HallResponse toResponse(Hall hall) {
        HallResponse hallResponse = new HallResponse();
        hallResponse.setId(hall.getId());
        hallResponse.setName(hall.getName());
        return hallResponse;
    }

    public List<HallResponse> toResponses(List<Hall> halls) {
        return halls.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

}
