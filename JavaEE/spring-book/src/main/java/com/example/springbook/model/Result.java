package com.example.springbook.model;

import com.example.springbook.enums.ResultEnom;
import lombok.Data;

@Data
public class Result {
    /**
    返回结果状态码
     */
    private ResultEnom code;
    /**
     * 结果详情信息
     */
    private String errMsg;
    /**
     * 结果数据
     */
    private Object data;

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultEnom.SUCCESS);
        result.setData(data);
        result.setErrMsg("success");
        return result;
    }

    public static Result success() {
        Result result = new Result();
        result.setCode(ResultEnom.SUCCESS);
        result.setData("");
        result.setErrMsg("success");
        return result;
    }

    public static Result fail(String errorMsg) {
        Result result = new Result();
        result.setCode(ResultEnom.FAIL);
        result.setData(null);
        result.setErrMsg(errorMsg);
        return result;
    }

    public static Result unlogin() {
        Result result = new Result();
        result.setCode(ResultEnom.UNLOGIN);
        result.setErrMsg("未登录");
        result.setData(null);
        return result;
    }
}
