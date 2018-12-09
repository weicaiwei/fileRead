package com.caiwei.utils;

public class ResultUtil {
    private static final String CODE_SUCCESS = "200";
    private static final String CODE_ERROR = "404";
    private static final String MESSAGE_ERROR = "账号或者密码错误";
    
    public static Result success(Object data) {
        return new Result(CODE_SUCCESS,data,"");
        
    }
    
    public static Result fail() {
        return new Result(CODE_ERROR,"",MESSAGE_ERROR);
    }

}
