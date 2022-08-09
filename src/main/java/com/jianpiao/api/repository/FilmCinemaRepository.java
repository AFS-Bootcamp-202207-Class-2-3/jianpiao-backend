package com.jianpiao.api.repository;

import com.jianpiao.api.model.entity.CinemaFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmCinemaRepository extends JpaRepository<CinemaFilm,String> {
    List<CinemaFilm> findAllByCinemaIdAndFilmId(String cinemaId, String filmId);

    List<CinemaFilm> findAllByCinemaIdAndStatus(String cinemaId, String status);

    List<CinemaFilm> findAllByFilmIdAndStatus(String filmId, String status);
}
