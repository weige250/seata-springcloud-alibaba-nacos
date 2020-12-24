package com.zskj.microservice.seataservice.storeservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.zskj.microservice.seataservice.storeservice.dao"})
public class SeataStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeataStoreApplication.class,args);
    }
}
