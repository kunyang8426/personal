package com.kazma.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 前端调用返回结果封装对象
 * <p>
 * Created by codingH on 2017/1/9.
 */
public class InvokeResult {

    public static final Integer INVOKE_RESULT_CODE_SUCCESS = 0;
    public static final Integer INVOKE_RESULT_CODE_UNKNOWNERROR = -99;
    public static final Integer DEFAULT_LEVER = 1;

    private Integer code = INVOKE_RESULT_CODE_SUCCESS;
    private String msg = "";
    private Map<String, Object> data = new HashMap<>();

    /**
     * 使用传入的参数,构建一个返回结果对象
     * Warning: 不会输出日志
     */
    public InvokeResult constuctResultUseGivenParam(InvokeResult invokeResult, Integer code, String msg) {
        invokeResult.setCode(code);
        invokeResult.setMsg(msg);
        return invokeResult;
    }

    /**
     * 使用传入的参数,构建一个返回结果对象
     * Warning: 不会输出日志
     */
    public InvokeResult constuctResultUseGivenParam(Integer code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }

    /**
     * 使用传入的参数,构建一个返回结果对象
     * Warning: 不会输出日志
     */
    public InvokeResult constuctResultUseGivenParam(InvokeResult invokeResult, Integer code, String msg, Map<String, Object> data) {
        invokeResult.setCode(code);
        invokeResult.setMsg(msg);
        invokeResult.setData(data);
        return invokeResult;
    }

    public InvokeResult putValue(String key, Object value) {
        this.data.put(key, value);
        return this;
    }


    /**
     * 将key,value直接放入data中
     */
    public InvokeResult putValueAndReturn(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public boolean isErr() {
        return !this.code.equals(0);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

}
