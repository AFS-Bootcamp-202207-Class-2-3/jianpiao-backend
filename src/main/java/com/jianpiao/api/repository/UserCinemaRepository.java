package com.jianpiao.api.repository;

import com.jianpiao.api.model.entity.Session;
import com.jianpiao.api.model.entity.UserCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: BaBy
 * @Date: 2022/8/10 22:26
 */
@Repository
public interface UserCinemaRepository extends JpaRepository<UserCinema, String> {
    List<UserCinema> findAllByUserId(String userId);
}
