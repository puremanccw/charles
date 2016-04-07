package com.charles.engine.redis;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class RedisUtil {
	
	@Resource
	private RedisTemplate<Serializable, Object> redisTemplate;
	
	/**
	 * 写入缓存
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(String key, Object value) {
		boolean result = false;
		try{
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			result = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 写入缓存，设置过期时间
	 * @param key
	 * @param value
	 * @param expireTime
	 * @return
	 */
	public boolean set(String key, Object value, Long expireTime) {
		boolean result = false;
		try{
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 读取缓存
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		Object result = null;
		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		result = operations.get(key);
		return result;
	}
	
	/**
	 * 判断缓存里是否有对应的key
	 * @param key
	 * @return
	 */
	public boolean exists(String key) {
		return redisTemplate.hasKey(key);
	}
	
	
	/**
	 * 批量删除对应的value
	 * @param keys
	 */
	public void remove(String... keys) {
		for(String key : keys) {
			remove(key);
		}
	}
	
	/**
	 * 批量删除key
	 * @param pattern
	 */
	public void removePattern(String pattern) {
		Set<Serializable> keys = redisTemplate.keys(pattern);
		if(keys.size() > 0) {
			redisTemplate.delete(keys);
		}
	}
	
	/**
	 * 删除对应的value
	 * @param key
	 */
	public void remove(String key) {
		if(exists(key)) {
			redisTemplate.delete(key);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
