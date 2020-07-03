package com.example.springbootmybatisplus.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 基于spring和redis的redisTemplate工具类
 * 针对所有的hash 都是以h开头的方法
 * 针对所有的Set 都是以s开头的方法不含通用方法
 * 针对所有的List 都是以l开头的方法
 *
 * @author
 */
@Component
public class RedisUtil {
    private Logger logger = LoggerFactory.getLogger(RedisUtil.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    //****************set放入缓存***************/

    /*public String getValue(String key, Integer timeOut) {
        long currentTimeMillis = System.currentTimeMillis();
        List<Object> objects = redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Nullable
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.bLPop(timeOut, key.getBytes());
            }
        }, new StringRedisSerializer());
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
        return null;
    }*/

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     */
    public <T> boolean set(String key, T value) {
        return set(key, value, null);
    }

    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) time要大于0 如果time小于等于0将设置无限期
     * @return true成功 false 失败
     */
    public <T> boolean set(String key, T value, @Nullable Long time) {
        if (StringUtils.isEmpty(key)) {
            return false;
        }
        String json = JSON.toJSONString(value);
        try {
            if (time != null && time > 0) {
                redisTemplate.opsForValue().set(key, json, time, TimeUnit.SECONDS);
            } else {
                redisTemplate.opsForValue().set(key, json);
            }
            return true;
        } catch (Exception e) {
            logger.error("Exception", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    //****************get取缓存***************/

    /**
     * 获取相应的缓存
     *
     * @param key  key
     * @param type 返回类型
     * @param <T>  返回类型
     * @return 返回值
     */
    public <T> T get(String key, Class<T> type) {
        if (StringUtils.isEmpty(key) || type == null) {
            return null;
        }
        String json = redisTemplate.opsForValue().get(key);
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        return JSONObject.parseObject(json, type);
    }

    /**
     * 获取所有键值对
     *
     * @param key 键值
     * @return 数据
     */
    public Map<Object, Object> getHash(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 获取所有键值对
     *
     * @param key 键值
     * @return 数据
     */
    public String getHashValue(String key, String hashKey) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(hashKey)) {
            return null;
        }
        Object obj = redisTemplate.opsForHash().get(key, hashKey);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    /**
     * 保存数据到Hash中
     *
     * @param redisKey 键值
     * @param hashKey  Hash键值
     * @param value    值
     * @return 状态
     */
    public Boolean setHash(String redisKey, String hashKey, String value) {
        if (StringUtils.isEmpty(redisKey) || StringUtils.isEmpty(hashKey) || StringUtils.isEmpty(value)) {
            return false;
        }
        redisTemplate.opsForHash().put(redisKey, hashKey, value);
        return true;
    }

    public Boolean delHashKey(String redisKey, String hashKey) {
        if (StringUtils.isEmpty(redisKey) || StringUtils.isEmpty(hashKey)) {
            return false;
        }
        redisTemplate.opsForHash().delete(redisKey, hashKey);
        return true;
    }

    public Boolean delHash(String redisKey) {
        if (StringUtils.isEmpty(redisKey)) {
            return false;
        }
        redisTemplate.delete(redisKey);
        return true;
    }


    /**
     * 获取相应的List缓存
     *
     * @param key  key
     * @param type lsit返回类型
     * @param <T>  返回类型
     * @return 返回值
     */
    public <T> T get(String key, TypeReference<T> type) {
        if (StringUtils.isEmpty(key) || type == null) {
            return null;
        }
        String json = redisTemplate.opsForValue().get(key);
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        return JSONObject.parseObject(json, type);
    }

    /**
     * 获取String类型
     *
     * @param key 缓存key
     * @return 返回值
     */
    public String get(String key) {
        return get(key, String.class);
    }

    //****************删除缓存***************/

    /**
     * 删除缓存
     *
     * @param key key
     * @return 结果
     */
    public boolean delete(String key) {
        if (StringUtils.isEmpty(key)) {
            return false;
        }
        return redisTemplate.delete(key);
    }

    /**
     * 删除多个缓存
     *
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    public void delete(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    //****************缓存时间***************/

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return true成功 false 失败
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            logger.error("Exception", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key获取过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    public Boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            logger.error("Exception", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 递增
     *
     * @param key   键
     * @param delta 要增加几(大于0)
     * @return 结果
     */
    public Long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     *
     * @param key   键
     * @param delta 要减少几(小于0)
     * @return 结果
     */
    public Long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }
}

