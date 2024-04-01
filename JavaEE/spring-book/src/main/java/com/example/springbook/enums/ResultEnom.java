package com.example.springbook.enums;

public enum ResultEnom {
    SUCCESS(0),
    FAIL(-1),
    UNLOGIN(-2);

    private Integer code;

    ResultEnom(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
