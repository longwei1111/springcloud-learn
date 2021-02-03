package com.coolw.springcloud.api;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @Classname CommonResult
 * @Description 统一返回结果
 * @Date 2021/2/2 11:09
 * @Author lw
 */
@Getter
@Setter
public class CommonResult<T> extends BaseDomain {

    private static final long serialVersionUID = -7438592192776174797L;

    public static final String SUCCESS = "s";
    public static final String FAIL = "f";

    private String flag;
    private String code;
    private String message;
    private T data;

    public boolean checkIfSuccess() {
        return Objects.equals(SUCCESS, flag);
    }

    public boolean checkIfFail() {
        return Objects.equals(FAIL, flag);
    }

    public CommonResult success() {
        CommonResult commonResult = new CommonResult();
        commonResult.setFlag(SUCCESS);
        return commonResult;
    }

    public CommonResult success(T data) {
        CommonResult commonResult = success();
        commonResult.setData(data);
        return commonResult;
    }

    public CommonResult fail() {
        CommonResult commonResult = new CommonResult();
        commonResult.setFlag(FAIL);
        return commonResult;
    }

    public CommonResult fail(String code, String message) {
        CommonResult commonResult = fail();
        commonResult.setCode(code);
        commonResult.setMessage(message);
        return commonResult;
    }
}
