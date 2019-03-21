package com.kazma.util;

import com.google.gson.internal.LinkedTreeMap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sfhq1873 on 2017/1/12.
 */
public class GsonArrayList<K> extends ArrayList<K>
        implements List<K>, Cloneable, Serializable  {

    public GsonArrayList(){

    }

    public GsonArrayList(List<? extends K> list){
        super(list);
    }

    public GsonHashMap optGsonHashMap(Integer index){
        return getGsonHashMap(index);
    }

    public GsonArrayList optGsonArrayList(Integer index){
        List e = (List)this.get(index);
        if (null == e) {
            return null;
        }
        return new GsonArrayList(e);
    }


    public Integer optInt(Integer index){
        Object e = this.get(index);
        if (null == e) {
            return null;
        }
        return e instanceof Number?((Number)e).intValue():(new Integer((String)e)).intValue();
    }

    public String optString(Integer index){
        Object o = this.get(index);
        return o==null?null:o.toString();
    }

    public Double optDouble(Integer index) {
        Object e = this.get(index);
        if (null == e) {
            return null;
        }
        return e instanceof Number?((Number)e).doubleValue():(new Double((String)e)).doubleValue();
    }
    public Long optLong(Integer index) {
        Object e = this.get(index);
        if (null == e) {
            return null;
        }
        return e instanceof Long?((Long)e).longValue():(new Long((String)e)).longValue();
    }

    public Boolean optBoolean(Integer index){
        Object o = this.get(index);
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

    public GsonHashMap getGsonHashMap(int index){
    	Object o= this.get(index);
    	if(null != o){
	    	if(o instanceof GsonHashMap){
	    		return (GsonHashMap)o;
	    	}
            if (o instanceof LinkedTreeMap) {
                return new GsonHashMap((LinkedTreeMap)o);
            }
        }
    	return new GsonHashMap();
    }
    
    
    
    public String toString(){
        return JsonUtil.getGson().toJson(this);
    }


}
