package com.jianpiao.api.repository;


import com.jianpiao.api.model.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, String> {
    @Query(value = "SELECT s FROM Session s WHERE s.filmId = :filmId and s.cinemaId = :cinemaId and (s.date > :curDate or (s.startTime >= :curTime and s.date = :curDate))")
    List<Session> findByCinemaIdAndFilmId(@Param("filmId") String filmId,
                                          @Param("cinemaId") String cinemaId,
                                          @Param("curDate") Date curDate,
                                          @Param("curTime") String curTime);
}
