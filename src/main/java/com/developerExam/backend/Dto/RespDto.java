package com.developerExam.backend.Dto;

public class RespDto<T> {

    private Integer ok;

    private Integer code;

    private String msg;

    private T data;

    public Integer getOk() {
        return ok;
    }

    public RespDto<T> setOk(Integer ok) {
        this.ok = ok;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public RespDto<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RespDto<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RespDto<T> setData(T data) {
        this.data = data;
        return this;
    }
}
