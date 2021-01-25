package com.zskj.serviceprovider.service.impl;

import com.zskj.serviceprovider.service.RedisTestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("RedisTestService")
public class RedisTestServiceImpl implements RedisTestService {
    private static final Log log = LogFactory.getLog(RedisTestServiceImpl.class);

    //写入redis cache缓存  evergrande::deptname
    @CachePut(key = "'deptname'",value="evergrande")
    @Override
    public String updatedata(String data) {
        return data;
    }

    //先读取redis cache缓存  evergrande::deptname，没有则执行函数读取
    @Cacheable(key = "'deptname'",value = "evergrande")
    @Override
    public String finddata() {
        log.info("execute find data method");
        return "it";
    }

    //删除redis cache缓存  evergrande::deptname
    @CacheEvict(key = "'deptname'",value = "evergrande")
    @Override
    public String deletedata(String key) {
        return null;
    }

}
