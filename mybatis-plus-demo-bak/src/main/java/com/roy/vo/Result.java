package com.roy.vo;



import com.roy.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * description： 通用实体返回类
 * author：dingyawu
 * date：created in 13:09 2020/11/12
 * history:
 */
@Data
@AllArgsConstructor
@ToString
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -1902455525299606460L;

    private boolean status = true;

    private String statusCode;

    private String message;

    private T result;


    public static Result error() {
        return new Result(false, ResultEnum.CODE_ERROR.getCode(), null, ResultEnum.CODE_ERROR.getMessage());
    }

    public static Result error(String statusCode, String message) {
        return new Result(false, message, null, statusCode);
    }

    public static Result error(ResultEnum resultEnum) {
        return new Result(false, resultEnum.getMessage(), null, resultEnum.getCode());
    }

    public static <T> Result<T> success(T data) {
        return new Result(true, ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> success() {
        return new Result(true, ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null);
    }

    public Result() {
    }


}

