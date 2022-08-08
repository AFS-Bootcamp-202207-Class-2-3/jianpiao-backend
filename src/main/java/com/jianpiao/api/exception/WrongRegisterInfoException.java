package com.jianpiao.api.exception;


/**
 * @Author: BaBy
 * @Date: 2022/8/8 11:23
 */
public class WrongRegisterInfoException extends RuntimeException {
    public String msg = "注册信息有误.";

    @Override
    public String getMessage() {
        return msg;
    }

    public WrongRegisterInfoException(String msg) {
        this.msg = msg;
    }
}
