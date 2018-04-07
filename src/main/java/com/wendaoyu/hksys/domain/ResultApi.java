package com.wendaoyu.hksys.domain;

public class ResultApi {
    private Integer code;
    private Object data;
    private String message;

    public ResultApi(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultApi(Integer code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
