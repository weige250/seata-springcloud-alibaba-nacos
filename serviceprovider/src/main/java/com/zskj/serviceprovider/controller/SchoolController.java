package com.zskj.serviceprovider.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zskj.serviceprovider.redis.RedisClient;
import com.zskj.serviceprovider.service.RedisTestService;
import com.zskj.serviceprovider.service.SchooleService;
import com.zskj.serviceprovider.util.RedisUtil;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SchoolController {
    private static final Log log = LogFactory.getLog(SchoolController.class);

    @Autowired
    RedisClient redisClient;

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Autowired
    SchooleService schooleService;

    @Autowired
    RedisTestService redisTestService;

    @GetMapping("/getname")
    private String getSchoolename(){
        log.info("service invoke");
        return schooleService.getSchooleDesc();
    }

    @GetMapping("/getdesc")
    private String getSchooledesc(){
        log.info("service invoke");

        RedisUtil redisUtil = new RedisUtil();
        redisUtil.setRedisTemplate(redisTemplate);
        String rv = redisUtil.get("rtmp");

        redisUtil.set("rtmp",rv+ String.valueOf(new Random().nextInt(10)));
        rv = redisUtil.get("rtmp");
        return rv;
        //return "zhongyingxiaoxue";
    }

    private String getCache(String key){
        String rv = redisTemplate.opsForValue().get(key);
        return rv;
    }

    private void setCache(String key,String value){
        redisTemplate.opsForValue().set(key,value);
        return ;
    }

    @GetMapping("/testcache")
    private void testcache(@Param("data") String data){
        String rv = redisTestService.finddata();
        log.info("before update redis  >>> key:deptname  "+"value:"+ rv);

        redisTestService.updatedata(data);

        //log.info("redis  === key:deptname  "+"value:"+this.getCache("deptname"));

        rv = redisTestService.finddata();
        log.info("redis  >>> key:deptname  "+"value:"+ rv);

        rv = redisTestService.finddata();
        log.info("redis  >>> key:deptname  "+"value:"+ rv);

        log.info("redistemplate read:"+this.getCache("evergrande::deptname"));


        this.setCache("deptname","testvalue");
        log.info("redistemplate read:"+this.getCache("deptname"));


    }

    @GetMapping("/deletecache")
    private void testdeletecache(@Param("data") String data) {
        redisTestService.deletedata(data);

        log.info("redistemplate read:"+this.getCache("evergrande::"+data));
    }
}
