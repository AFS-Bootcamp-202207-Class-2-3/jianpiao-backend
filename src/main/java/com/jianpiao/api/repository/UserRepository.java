package com.jianpiao.api.repository;

import com.jianpiao.api.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: BaBy
 * @Date: 2022/8/6 17:16
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUsernameAndPassword(String username, String password);
}
