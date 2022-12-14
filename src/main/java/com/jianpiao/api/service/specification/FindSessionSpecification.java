package com.jianpiao.api.service.specification;

import com.jianpiao.api.model.entity.Cinema;
import com.jianpiao.api.model.entity.Film;
import com.jianpiao.api.model.entity.Session;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FindSessionSpecification implements Specification<Session> {

    private String cinemaId;
    private String filmId;
    private Date curDate;
    private String curTime;
    private Boolean needOrderByDate;

    public FindSessionSpecification(String cinemaId, String filmId, Date curDate, String curTime, boolean needOrderByDate) {
        this.cinemaId = cinemaId;
        this.filmId = filmId;
        this.curDate = curDate;
        this.curTime = curTime;
        this.needOrderByDate = needOrderByDate;
    }

    public FindSessionSpecification() {
    }

    @Override
    public Predicate toPredicate(Root<Session> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList();
        Predicate finalPredicate = null;
        if (Objects.nonNull(cinemaId)) {
            Path<Cinema> cinema = root.get("cinema");
            predicates.add(criteriaBuilder.equal(cinema.get("id"), cinemaId));
        }
        if (Objects.nonNull(filmId)) {
            Path<Film> film = root.get("film");
            predicates.add(criteriaBuilder.equal(film.get("id"), filmId));
        }
        if (needOrderByDate) {
            Path<Date> date = root.get("date");
            Predicate datePredicate = criteriaBuilder.greaterThan(date, curDate);

            Path<String> startTime = root.get("startTime");
            Predicate startTimePredicate = criteriaBuilder.and(criteriaBuilder.equal(date, curDate), criteriaBuilder.greaterThan(startTime, curTime));
            Predicate dateTimePredicate = criteriaBuilder.or(datePredicate, startTimePredicate);
            finalPredicate = predicates.stream()
                    .reduce(dateTimePredicate, criteriaBuilder::and);
        } else {
            finalPredicate = predicates.stream()
                    .reduce(predicates.get(0), criteriaBuilder::and);
        }

        return query.where(finalPredicate).getGroupRestriction();
    }
}
