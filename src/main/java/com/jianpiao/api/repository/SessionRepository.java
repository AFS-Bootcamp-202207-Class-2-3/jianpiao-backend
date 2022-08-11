package com.jianpiao.api.repository;


import com.jianpiao.api.model.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, String>, JpaSpecificationExecutor {

    List<Session> findAllByDate(Date date);
}
