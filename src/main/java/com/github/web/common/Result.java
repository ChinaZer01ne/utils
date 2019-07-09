package com.github.web.common;

import java.io.Serializable;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/8 14:58
 */
public class Result<T> implements Serializable {

    private int code;
    private String message;
    private T data;

    private Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success(){
        return new Result<>(200,"操作成功",null);
    }

    public static <T> Result<T> success(T data){
        return new Result<>(200,"操作成功",data);
    }

    public static Result error(){
        return new Result<>(200,"操作成功",null);
    }

    public static Result error(String message){
        return new Result<>(500,message,null);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
