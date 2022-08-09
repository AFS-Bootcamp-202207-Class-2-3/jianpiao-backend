package com.jianpiao.api.repository;

import com.jianpiao.api.model.entity.CinemaFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaFilmRepository extends JpaRepository<CinemaFilm, String> {

    List<CinemaFilm> findByFilmId(String filmId);

}
