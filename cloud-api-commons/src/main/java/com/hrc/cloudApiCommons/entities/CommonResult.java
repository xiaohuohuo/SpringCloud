package com.hrc.cloudApiCommons.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String  message;
    private T data;

    public static <T> CommonResult error(String message, T data){
        CommonResult<Object> result = new CommonResult<>();
        result.code = 404;
        result.message = message;
        result.data = data;
        return result;
    }

    public static <T> CommonResult success(String message, T data){
        CommonResult<Object> result = new CommonResult<>();
        result.code = 200;
        result.message = message;
        result.data = data;
        return result;
    }

}
