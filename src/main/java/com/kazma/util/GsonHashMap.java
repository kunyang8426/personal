package com.kazma.util;

import com.google.gson.internal.LinkedTreeMap;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by codingH on 2017/1/12.
 */
public class GsonHashMap<K,V>
        extends HashMap<K,V>
        implements Map<K,V>, Cloneable, Serializable {

    private static final long serialVersionUID = 8886558699907642032L;

    public GsonHashMap(){

    }

    public GsonHashMap(Map<? extends K, ? extends V> m){
        super(m);
    }

    public boolean has(String key) {
    	return this.containsKey(key) && this.get(key) != null;
    }

    public Integer optInt(String key){
//        Object e = this.get(key);
//        if (null == e) {
//            return null;
//        }
//        return e instanceof Number?((Number)e).intValue():(new Integer((String)e)).intValue();
        return optIntWithDefault(key, 0);
    }

    public Integer optIntWithoutDefault(String key){
        Object e = this.get(key);
        return castToInteger(e);
    }

    public Integer optIntWithDefault(String key,Integer defaultValue){
        Object e = this.get(key);
        if (null == e) {
            return defaultValue;
        }
        return e instanceof Number?((Number)e).intValue():(new Integer((String)e)).intValue();
    }

    public String optString(String key){
        Object o = this.get(key);
        if (o instanceof String) {
            return o==null?null:o.toString();
        }else{
            return o==null?null:JsonUtil.getGson().toJson(o);
        }
    }

    public Double optDouble(String key) {
        Object e = this.get(key);
        if (null == e) {
            return new Double(0.0);
        }
        return e instanceof Number?((Number)e).doubleValue():(new Double((String)e)).doubleValue();
    }
    public Long optLong(String key) {
        Object e = this.get(key);
        if (null == e) {
            return null;
        }
        return e instanceof Number?((Number)e).longValue():(new Long((String)e)).longValue();
    }

    public Boolean optBoolean(String key){
        Object o = this.get(key);
        if(o != null) {
            if(o.equals(Boolean.FALSE) || o instanceof String && ((String)o).equalsIgnoreCase("false")) {
                return false;
            }

            if(o.equals(Boolean.TRUE) || o instanceof String && ((String)o).equalsIgnoreCase("true")) {
                return true;
            }
        }
        return null;
    }

	public Boolean optBoolean(String key, boolean defaultVal){
		Object o = this.get(key);
		if(o != null) {
			if(o.equals(Boolean.FALSE) || o instanceof String && ((String)o).equalsIgnoreCase("false")) {
				return false;
			}

			if(o.equals(Boolean.TRUE) || o instanceof String && ((String)o).equalsIgnoreCase("true")) {
				return true;
			}
		}
		return defaultVal;
	}

    public GsonHashMap optGsonHashMap(String key){
        LinkedTreeMap e = (LinkedTreeMap)this.get(key);
        if (null == e) {
            return null;
        }
        return new GsonHashMap(e);
    }

    public GsonArrayList optGsonArrayList(String key){
        List e = (List)this.get(key);
        if (null == e) {
            return null;
        }
        return new GsonArrayList(e);
    }


    public String toString(){
        return JsonUtil.getGson().toJson(this);
    }

    public  Integer castToInteger(Object o){
        if (o instanceof Integer) {
            return (Integer) o;
        }
        if (o instanceof String) {
            return Integer.parseInt((String)o);
        }
        return -1;
    }

}
