package com.springcloud.commoncore.entity;

import java.io.Serializable;

public class Result implements Serializable {

    private static final long serialVersionUID = -4677836646635680686L;

    private int code;
    private String message;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
