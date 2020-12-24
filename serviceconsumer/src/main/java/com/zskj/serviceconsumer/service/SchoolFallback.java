package com.zskj.serviceconsumer.service;

public class SchoolFallback implements SchooleService{
    public String getName() {
        return "retry it";
    }
}
