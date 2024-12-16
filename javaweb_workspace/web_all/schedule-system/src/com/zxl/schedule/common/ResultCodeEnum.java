package com.zxl.schedule.common;

public enum ResultCodeEnum {
    //业务含义和状态码的对应关系
    SUCCESS(200, "success"),
    USERNAME_ERROR(501, "usernameError"),
    PASSWORD_ERROR(503, "passwordError"),
    NOTLOGIN(504,"notLogin"),
    USERNAME_USED(505,"usernameUsed");

    private Integer code;
    private String message;
    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}