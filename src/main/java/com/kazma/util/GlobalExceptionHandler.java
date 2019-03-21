package com.kazma.util;

import com.kazma.entity.InvokeResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 全局异常处理
 * Created by chenxd on 2017/1/20.
 */
@ControllerAdvice
public class GlobalExceptionHandler {


	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleException(Exception ex) {
		InvokeResult result = new InvokeResult();
		result = result.constuctResultUseGivenParam(-99, "服务器异常");
		logger.error("controller throw a exception : ", ex);
		return JsonUtil.getGson().toJson(result);
	}


}
