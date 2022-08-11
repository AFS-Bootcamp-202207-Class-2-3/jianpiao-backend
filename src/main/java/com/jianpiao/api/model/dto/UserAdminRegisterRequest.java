package com.jianpiao.api.model.dto;

import com.jianpiao.api.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: BaBy
 * @Date: 2022/8/6 17:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAdminRegisterRequest extends User {
    private String InvitationCode;
}
