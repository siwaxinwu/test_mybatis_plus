package com.roy.enums;

import lombok.Getter;
import lombok.ToString;

/**
 * description：返回的消息枚举
 * 业务错误：4XX开头
 * author：dingyawu
 * date：created in 11:19 2020/9/21
 * history:
 */
@Getter
@ToString
public enum ResultEnum {
	SUCCESS("200", "操作成功"),
    CODE_ERROR("500","后台程序报错，请联系管理员"),
    PARAM_MISS("101","参数缺失");
    private String code;
    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}