package com.example.springbook.enums;

public enum BookStatusEnum {
    DELETED(0, "删除"),
    NORMAL(1, "可借阅"),
    FORBID(2,"不可借阅");

    public static BookStatusEnum getStatusCNByCode(Integer code) {
        switch (code) {
            case 0: return BookStatusEnum.DELETED;
            case 1: return BookStatusEnum.NORMAL;
            default:
                return BookStatusEnum.FORBID;
        }
    }
    private Integer code;
    private String statusCN;
    BookStatusEnum(Integer code, String statusCN) {
        this.code = code;
        this.statusCN = statusCN;
    }

    public String getStatusCN() {
        return statusCN;
    }

    public void setStatusCN(String statusCN) {
        this.statusCN = statusCN;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
