package com.helloWorld.helloWorld.common.utils.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class RedisUtils {
    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisUtils(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public RedisConnectionFactory getConnectionFactory() {
        return stringRedisTemplate.getConnectionFactory();
    }

    public <T> T execute(RedisCallback<T> redisCallback) {
        return stringRedisTemplate.execute(redisCallback);
    }

    public <T> T execute(SessionCallback<T> sessionCallback) {
        return stringRedisTemplate.execute(sessionCallback);
    }

    /**
     * Add expiration time to key
     */
    public Boolean expire(String key, Duration timeout) {
        return stringRedisTemplate.expire(key, timeout);
    }

    /**
     * Specify expiration time for key
     */
    public Boolean expireAt(String key, Instant expireAt) {
        return stringRedisTemplate.expireAt(key, expireAt);
    }

    /**
     * Get the expiration time of the specified key
     */
    public Long getExpire(String key) {
        return stringRedisTemplate.getExpire(key);
    }

    /**
     * Modify key name
     */
    public void rename(String key, String newKey) {
        stringRedisTemplate.rename(key, newKey);
    }

    public Long delete(Collection<String> keys) {
        return stringRedisTemplate.delete(keys);
    }

    public Boolean delete(String key) {
        return stringRedisTemplate.delete(key);
    }

    /**
     * Does the key exist?
     */
    public Boolean exists(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    /**
     * Delete one or more key-values. However, compared to DEL, which blocks,
     * this command reclaims memory in another thread, so it is non-blocking.
     */
    public Long unlink(String... keys) {
        return stringRedisTemplate.unlink(Arrays.asList(keys));
    }

    /**
     * Delete one or more key-values. However, compared to DEL, which blocks,
     * this command reclaims memory in another thread, so it is non-blocking.
     */
    public Boolean unlink(String key) {
        return stringRedisTemplate.unlink(key);
    }

    /**
     * Set String type key-value
     */
    public void strSet(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * Set String type key-value and add expiration time @param timeout expiration time
     */
    public void strSet(String key, String value, Duration timeout) {
        stringRedisTemplate.opsForValue().set(key, value, timeout);
    }

    /**
     * Add key-value in batches. If the key already exists, the original value will be overwritten.
     */
    public void strMSet(Map<String, String> keyAndValue) {
        stringRedisTemplate.opsForValue().multiSet(keyAndValue);
    }

    /**
     * Get String type key-value
     */
    public String strGet(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * Get the value of the key of type String, and then delete this key <p>If this key does not exist,
     * return null<p> @since Redis Version: 6.2
     */
    public String strGetAndDelete(String key) {
        return stringRedisTemplate.opsForValue().getAndDelete(key);
    }

    /**
     * Get the value of a key of type String and then append the expiration time
     * <p>If this key does not exist, return null<p>
     *
     * @since Redis Version: 6.2
     */
    public String strGetAndExpire(String key, Duration timeout) {
        return stringRedisTemplate.opsForValue().getAndExpire(key, timeout);
    }

    /**
     * Get key values in batches. If a key does not exist,
     * it will be returned in the form of null, and the number will remain consistent.
     */
    public List<String> strMGet(Collection<String> keys) {
        return stringRedisTemplate.opsForValue().multiGet(keys);
    }

    /**
     * Add Hash key-value pairs
     */
    public void hSet(String key, String hashKey, String value) {
        stringRedisTemplate.opsForHash().put(key, hashKey, value);
    }

    /**
     * Get the value of hashKey under the specified key
     */
    public Object hGet(String key, String hashKey) {
        return stringRedisTemplate.opsForHash().get(key, hashKey);
    }

    public boolean hasKey(String key) {
        return Boolean.TRUE.equals(stringRedisTemplate.hasKey(key));
    }

}


