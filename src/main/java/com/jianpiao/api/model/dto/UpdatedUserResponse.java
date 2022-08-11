package com.jianpiao.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedUserResponse {

    private String username;
    private String nickname;
    private String photo;
    private String name;
    private String gender;
    private String tel;
    private String email;

}
