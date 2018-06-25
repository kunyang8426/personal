package com.kazma.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sfbest.brokerservice.entity.common.DefaultTypeToken;
import com.sfbest.brokerservice.web.BooleanAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * json工具类
 * Created by codingH on 2017/1/10.
 */
public class JsonUtil {

	private static final Gson gson;

	static {
		gson = new GsonBuilder()
				.registerTypeAdapter(Boolean.class, new BooleanAdapter())
				.registerTypeAdapter(boolean.class, new BooleanAdapter())
				.create();
	}

	/**
	 * 取出map中第一级内容,其余转换成string
	 * @param json json src
	 */
	public static Map<String, String> outboxOneLevelMap(String json) {
		if(json==null){
			return new HashMap<String,String>();
		}
		Map temp = gson.fromJson(json, HashMap.class);
		Map<String, String> result = new HashMap<String,String>();
		for (Object key : temp.keySet()) {
			String temps = gson.toJson(temp.get(key));
			if (temps==null)
				temps = "null";
			else if ("".equals(temps) || temps.startsWith("[") || temps.startsWith("{")) {
				//do nothing
			}
			else if(temps.startsWith("\"") && temps.endsWith("\"")){
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < temps.length(); i++) {
					if (i != 0 && i != temps.length() - 1) {
						sb.append(temps.charAt(i));
					}
				}
				temps = sb.toString();
			}
			/*else
				temps = temps.substring(1, temps.length() - 1);*/
			result.put(String.valueOf(key), temps);
		}
		return result;
	}

	/**
	 * json转换成java对象
	 * @param json
	 * @param cls
	 * @param <T>
	 * @return
	 */
	public static <T> T getFromJson(String json, Class<T> cls) {
		return gson.fromJson(json, cls);
	}

	/**
	 * json转换成带泛型的java对象
	 * @param json
	 * @param typeToken
	 * @param <T>
	 * @return
	 */
	public static <T> T getFromJson(String json, DefaultTypeToken typeToken) {
		return gson.fromJson(json, typeToken.getType());
	}

	public static Gson getGson() {
		return gson;
	}
	/**
	 * 对象转换为字符串
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}

}
