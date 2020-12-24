package com.zskj.serviceprovider.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zskj.serviceprovider.redis.RedisClient;
import com.zskj.serviceprovider.service.SchooleService;
import com.zskj.serviceprovider.util.RedisUtil;
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
    RedisTemplate redisTemplate;

    @Autowired
    SchooleService schooleService;

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
}
