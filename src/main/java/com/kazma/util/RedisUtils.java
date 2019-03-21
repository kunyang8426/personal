package com.kazma.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * Created by 80002526 on 2018/8/7.
 */
@Service
public class RedisUtils {

    @Autowired
    private JedisPool masterjedisPool;

    //user session失效时间
    public static final int USER_SESSION_EXPIRED_SECONDS = 24 * 3600;

    public void setString(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = masterjedisPool.getResource();
            jedis.set(key, value);
        }catch (Exception ignored){
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    public Long zadd(String key, Integer score, String value, int expireSeconds) {
        Jedis jedis = null;
        try {
            jedis = masterjedisPool.getResource();
            Long zadd = jedis.zadd(key, score, value);
            jedis.expire(key, expireSeconds);
            return zadd;
        }catch (Exception ignored){
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return 0L;
    }
    public Set<String> zrange(String key, Integer start, Integer end) {
        Jedis jedis = null;
        try {
            jedis = masterjedisPool.getResource();
            return jedis.zrange(key, start, end);
        }catch (Exception ignored){
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }
    public Long zcard(String key) {
        Jedis jedis = null;
        try {
            jedis = masterjedisPool.getResource();
            return jedis.zcard(key);
        }catch (Exception ignored){
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return 0L;
    }

    @SuppressWarnings("WeakerAccess")
    public void setStringWithExpired(String key, String value, int expired) {
        Jedis jedis = null;
        try {
            jedis = masterjedisPool.getResource();
            jedis.set(key, value);
            jedis.expire(key, expired);
        }catch (Exception ignored){
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public String getString(String key) {
        Jedis jedis = null;
        try {
            jedis = masterjedisPool.getResource();
            return jedis.get(key);
        }catch (Exception e){
            return null;
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public void delString(String key) {
        Jedis jedis = null;
        try {
            jedis = masterjedisPool.getResource();
            jedis.del(key);
        }catch (Exception ignored){
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public Long expire(String key, int seconds) {
        Jedis jedis = null;
        try {
            jedis = masterjedisPool.getResource();
            return jedis.expire(key, seconds);
        }catch (Exception e){
            return null;
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    public boolean keyExit(String key) {
        Jedis jedis = null;
        try {
            jedis = masterjedisPool.getResource();
            return jedis.exists(key);
        }catch (Exception e){
            return false;
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public void delFloorResourcesAll(){
        Jedis jedis = null;
        try {
            jedis = masterjedisPool.getResource();
            Set<String> keys = jedis.keys("FLOOR_RESOURCES_ALL*");
            for(String key : keys) {
                jedis.del(key);
            }
        }catch (Exception ignored){
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public void delNewFloorResourcesAll(){
        Jedis jedis = null;
        try {
            jedis = masterjedisPool.getResource();
            Set<String> keys = jedis.keys("NEW_FLOOR*");
            for(String key : keys) {
                jedis.del(key);
            }
        }catch (Exception ignored){
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public String getUserSession(String token){
        Jedis jedis = null;
        try {
            jedis = masterjedisPool.getResource();
            String userSession =  jedis.get("TOKEN" + token);
            if (Check.NULL.NuNStr(userSession)) {
                return "0";
            }
            jedis.expire("TOKEN" + token, USER_SESSION_EXPIRED_SECONDS);
            return userSession;

        }catch (Exception e){
            return null;
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
