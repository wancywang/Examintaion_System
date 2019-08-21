package com.system.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * @Author: Alex
 * @Date: 2019/8/20 14:43
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseEnvelope<T> {
    private Integer code;

    private String message;

    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseEnvelope(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseEnvelope(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
