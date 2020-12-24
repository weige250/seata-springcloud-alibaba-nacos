package com.zskj.serviceprovider.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Random;

@Component
public class RedisClient {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.database}")
    private int database;


    public String testJedisPool() {
//       创建一个连接池对象
        JedisPool jedisPool = new JedisPool(host, port);
//   从连接池中获取连接
        Jedis jedis = jedisPool.getResource();
//        指定数据库
        jedis.select(database);

        String resoult = jedis.get("mytest");
        System.out.println(resoult);

        jedis.set("mytest",resoult+ String.valueOf(new Random().nextInt(10)));
        resoult = jedis.get("mytest");
        System.out.println("after :"+resoult);

//        关闭连接
        jedis.close();
//        关闭连接池
        jedisPool.close();

        return resoult;
    }
}
