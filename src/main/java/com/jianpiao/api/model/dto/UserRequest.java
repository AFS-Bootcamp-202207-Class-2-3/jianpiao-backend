package com.jianpiao.api.model.dto;

import com.jianpiao.api.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author: BaBy
 * @Date: 2022/8/6 17:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String id;
    private String username;
    private String password;
    private String nickname;
    private String photo;
    private String name;
    private String gender;
    private String tel;
    private String email;
}
