package com.jianpiao.api.service.specification;

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

    public FindSessionSpecification(String cinemaId, String filmId, Date curDate, String curTime) {
        this.cinemaId = cinemaId;
        this.filmId = filmId;
        this.curDate = curDate;
        this.curTime = curTime;
    }

    public FindSessionSpecification() {
    }

    @Override
    public Predicate toPredicate(Root<Session> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList();
        if (Objects.nonNull(cinemaId)) {
            Path<String> cid = root.get("cinemaId");
            predicates.add(criteriaBuilder.equal(cid, cinemaId));
        } else if (Objects.isNull(filmId)) {
            Path<String> fId = root.get("filmId");
            predicates.add(criteriaBuilder.equal(fId, filmId));
        }
        Path<Date> date = root.get("date");
        Predicate datePredicate = criteriaBuilder.greaterThan(date, curDate);

        Path<String> startTime = root.get("startTime");
        Predicate startTimePredicate = criteriaBuilder.and(criteriaBuilder.equal(date, curDate), criteriaBuilder.greaterThan(startTime, curTime));
        Predicate dateTimePredicate = criteriaBuilder.or(datePredicate, startTimePredicate);

        Predicate finalPredicate = predicates.stream()
                .reduce(dateTimePredicate, (predicate, predicate2) -> criteriaBuilder.and(predicate, predicate2));

        return query.where(finalPredicate).getGroupRestriction();
    }
}
