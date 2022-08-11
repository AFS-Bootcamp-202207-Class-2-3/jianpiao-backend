package com.jianpiao.api.model.dto;

import lombok.Data;

/**
 * @Author: Berlin
 * @Date: 2022/8/10 13:44
 */
@Data
public class CinemaAdminRequest {

    private String address;

    private String contactNumber;

    public CinemaAdminRequest(String address, String contactNumber) {
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public CinemaAdminRequest() {
    }
}
