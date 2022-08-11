package com.jianpiao.api.exception;


public class ParamNotSatisfiedException extends RuntimeException {

    public static final String PARAM_NOT_SATISFIED_EXCEPTION = "ParamNotSatisfiedException";

    @Override
    public String getMessage() {
        return PARAM_NOT_SATISFIED_EXCEPTION;
    }
}
