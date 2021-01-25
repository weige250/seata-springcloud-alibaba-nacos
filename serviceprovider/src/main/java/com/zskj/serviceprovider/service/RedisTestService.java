package com.zskj.serviceprovider.service;

public interface RedisTestService {
    public String updatedata(String data);
    public String finddata();
    public String deletedata(String key);
}
