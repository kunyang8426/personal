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

    /**
     * 构建一个新的未知异常对象
     * 附带日志输出
     */
   /* private InvokeResult constuctUnknownErrorResult(Exception e, String logmsg) {
        InvokeResult invokeResult = new InvokeResult();
        if (e instanceof BusinessException) {
            invokeResult.setCode(((BusinessException) e).getCode());
            invokeResult.setMsg(((BusinessException) e).getMsg());
        } else {
            invokeResult.setCode(INVOKE_RESULT_CODE_UNKNOWNERROR);
            invokeResult.setMsg("未知异常");
        }
        logger.error(logmsg, e);
        return invokeResult;
    }

    *//**
     * 构建一个新的未知异常对象
     * 附带日志输出
     *//*
    public InvokeResult constuctUnknownErrorResult(Logger outlogger, Exception e, String className, String methodName) {
        String logmsg = "Unknown Err." + LogUtil.getMonitorLevel(DEFAULT_LEVER) + "ClassName-->" + className + LogUtil.getMonitorMsg(methodName);
        outlogger.error(logmsg, e);
        return constuctUnknownErrorResult(e, logmsg);
    }

    *//**
     * 使用传入的参数,构建一个返回结果对象
     * <p>
     * 建议错误时使用,会输出日志,包含Exception信息
     *//*
    private InvokeResult constuctResultUseGivenParam(Integer code, String msg, String logmsg, Exception e) {
        this.setCode(code);
        this.setMsg(msg);
        logger.error(logmsg, e);
        return this;
    }

    *//**
     * 使用传入的参数,构建一个返回结果对象
     * <p>
     * 建议错误时使用,会输出日志,包含Exception信息
     *//*
    public InvokeResult constuctResultUseGivenParam(Logger outlogger, Integer code, String msg, Exception e, String className, String methodName, String customInfo) {
        String logmsg = "err." + LogUtil.getMonitorLevel(DEFAULT_LEVER) + "." + className + "." + methodName + "..code:" + code + LogUtil.getMonitorMsg(msg) + ".info:" + customInfo;
        outlogger.error(logmsg, e);
        return constuctResultUseGivenParam(code, msg, logmsg, e);
    }

    *//**
     * 使用传入的参数,构建一个返回结果对象
     * <p>
     * 建议逻辑错误时使用,会输出日志,日志不包含Exception信息
     *//*
    private InvokeResult constuctResultUseGivenParam(Integer code, String msg, String logmsg) {
        this.setCode(code);
        this.setMsg(msg);
        logger.error(logmsg);
        return this;
    }

    *//**
     * 使用传入的参数,构建一个返回结果对象
     * <p>
     * 建议逻辑错误时使用,会输出日志,日志不包含Exception信息
     *//*
    public InvokeResult constuctResultUseGivenParam(Logger outlogger, Integer code, String msg, String className, String methodName, String customInfo) {
        String logmsg = "err." + LogUtil.getMonitorLevel(DEFAULT_LEVER) + "." + className + "." + methodName + "..code:" + code + LogUtil.getMonitorMsg(msg) + ".info:" + customInfo;
        outlogger.error(logmsg);
        return constuctResultUseGivenParam(code, msg, logmsg);
    }

    public InvokeResult conErrWithWarnLog(Logger outlogger, Integer code, String msg, String className, String methodName, String customInfo){
        outlogger.warn("warning! {}.{}..code:{}.msg:{}.info:{}", className, methodName, code, msg, customInfo);
        return constuctResultUseGivenParam(code, msg);
    }

    *//**
     * 将key,value直接放入data中
     *//*
    public InvokeResult putValue(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public InvokeResult constuctResultUseGivenParam(Logger outlogger, Integer code, String msg, String className, String methodName, String customInfo, int level) {
        String logmsg = "err." + LogUtil.getMonitorLevel(level) + "." + className + "." + methodName + "..code:" + code + LogUtil.getMonitorMsg(msg) + ".info:" + customInfo;
        outlogger.error(logmsg);
        return constuctResultUseGivenParam(code, msg, logmsg);
    }

    public InvokeResult constuctResultUseGivenParam(Logger outlogger, Integer code, String msg, Exception e, String className, String methodName, String customInfo, int level) {
        String logmsg = "err." + LogUtil.getMonitorLevel(level) + "." + className + "." + methodName + "..code:" + code + LogUtil.getMonitorMsg(msg) + ".info:" + customInfo;
        outlogger.error(logmsg, e);
        return constuctResultUseGivenParam(code, msg, logmsg, e);
    }

    public InvokeResult constuctUnknownErrorResult(Logger outlogger, Exception e, String className, String methodName, int level) {
        String logmsg = "Unknown Err." + LogUtil.getMonitorLevel(level) + "ClassName-->" + className + LogUtil.getMonitorMsg(methodName);
        outlogger.error(logmsg, e);
        return constuctUnknownErrorResult(e, logmsg);
    }

    public InvokeResult constuctResultUseGivenParam(Logger outlogger, Integer code, String msg, String className, String methodName, String customInfo, int level, String monitorMsg) {
        String logmsg = "err." + LogUtil.getMonitorLevel(level) + "." + className + "." + methodName + "..code:" + code + LogUtil.getMonitorMsg(monitorMsg) + ".info:" + customInfo;
        outlogger.error(logmsg);
        return constuctResultUseGivenParam(code, msg, logmsg);
    }

    public InvokeResult constuctResultUseGivenParam(Logger outlogger, Integer code, String msg, Exception e, String className, String methodName, String customInfo, int level, String monitorMsg) {
        String logmsg = "err." + LogUtil.getMonitorLevel(level) + "." + className + "." + methodName + "..code:" + code + LogUtil.getMonitorMsg(monitorMsg) + ".info:" + customInfo;
        outlogger.error(logmsg, e);
        return constuctResultUseGivenParam(code, msg, logmsg, e);
    }*/

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
