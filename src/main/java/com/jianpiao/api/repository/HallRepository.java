package com.jianpiao.api.repository;

import com.jianpiao.api.model.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallRepository extends JpaRepository<Hall, String> {
    List<Hall> findByCinemaId(String cinemaId);
}
