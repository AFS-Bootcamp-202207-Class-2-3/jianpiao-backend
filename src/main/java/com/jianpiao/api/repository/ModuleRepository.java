package com.jianpiao.api.repository;

import com.jianpiao.api.model.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: BaBy
 * @Date: 2022/8/6 17:16
 */
@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {

}
