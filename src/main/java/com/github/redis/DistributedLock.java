package com.github.redis;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;
import java.util.Objects;

/**
 * redis分布式锁
 * setnx:如果不存在这个key才设置
 * @Author: Zer01ne
 * @Date: 2019/2/19 10:11
 * @Version 1.0
 */
public class DistributedLock {

    private static final String host;
    private static final int post;
    private static final JedisPool jedisPool;

    static {
        host = "127.0.0.1";
        post = 6379;
        jedisPool = new JedisPool(host,post);
    }
    private RedisTemplate redisTemplate;

    public boolean getLockByRedisTemplate(String lockKey, String requestId, int timeout){
        return false;
    }
    /**
     * Jedis set的方式（正确方式）
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param timeout 超时时间
     */
    public boolean getLockByJedis(String lockKey, String requestId, int timeout){
        Jedis jedis = getJedis();
        String result = jedis.set(lockKey, requestId, "NX", "EX", timeout);
        if (Objects.equals(result,"OK")){
            return true;
        }
        return false;
    }
    /**
     * Jedis setnx的方式(存在问题)
     */
    public boolean getLockByJedis2(String lockKey, String requestId, int timeout){
        Jedis jedis = getJedis();
        Long result = jedis.setnx(lockKey, requestId);
        /**
         *  设置过期时间，如果此时程序崩溃，设置超时时间失败，就会存在死锁的问题
         */

        if (result == 1){
            jedis.expire(lockKey,timeout);
            return true;
        }
        return false;
    }
    /**
     * Jedis setnx的方式(存在问题)
     */
    public static boolean wrongGetLock(Jedis jedis, String lockKey, Integer expireTime) {
        long time = System.currentTimeMillis() + expireTime;
        String expireStr = String.valueOf(time);
        //如果锁不存在则返回加锁成功
        /**
         * 第二参数是key的value值（把过期时间作为的value）
         * */
        if (jedis.setnx(lockKey, expireStr) == 1) {
            return true;
        }
        //如果锁存在则获取锁的过期时间
        String currentValueStr = jedis.get(lockKey);
        if (null == currentValueStr) {
            return false;
        }
        //锁未过期直接返回成功
        /**
         * 锁是否过期的判断逻辑并不是以设置redis中key的过期时间来限制的，而是以程序中的系统时间和redis中key的value值比较进行判断的
         * */
        if (Long.parseLong(currentValueStr) > System.currentTimeMillis()) {
            return true;
        }
        /**
         * 锁已过期，获取上一个锁的过期时间并设置现在锁的过期时间
         * (比如有两个线程，线程A和线程B，线程A执行jedis.getSet获得一个oldValueStr1，
         * 线程B此时也竞争锁，执行jedis.getSet获得一个oldValueStr2（这个getSet获得的oldValueStr2其实是线程A写入的expireStr）)
         * 只有lockKey存在的旧职和currentValueStr相等才设置值（也就是第一个执行jedis.getSet的方法可以获取锁）
         */
        String oldValueStr = jedis.getSet(lockKey, expireStr);
        //多线程并发的情况，只有一个线程的设置值和当前值相同，才有权利加锁
        if (oldValueStr.equals(currentValueStr)) {
            return true;
        }
        return false;
    }
    /**
     * 释放锁操作,del的方法（存在问题）
     * 问题：如果客户端A加锁，一段时间后客户端A解锁，在执行jedis.del();之前，锁突然过期了，客户端B加了锁，此时客户端A会把客户端B的锁释放
     */
    public void releaseLockByJedis(String lockKey, String requestId){
        Jedis jedis = getJedis();
        if (Objects.equals(requestId,jedis.get(lockKey))){

            jedis.del(lockKey);
        }
    }

    /**
     * 释放分布式锁(正确方式，Lua语言)
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (Objects.equals(1L,result)) {
            return true;
        }
        return false;

    }
    private static Jedis getJedis(){
        return jedisPool.getResource();
    }
    public static void main(String[] args) {
        wrongGetLock(getJedis(),"lockKey",3000);
    }
}
