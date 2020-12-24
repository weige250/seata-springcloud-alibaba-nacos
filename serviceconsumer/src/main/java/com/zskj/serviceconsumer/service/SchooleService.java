package com.zskj.serviceconsumer.service;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="service-01",fallbackFactory = SchoolFallback.class)
public interface SchooleService {
    @GetMapping("/getname")
    String getName();
}
