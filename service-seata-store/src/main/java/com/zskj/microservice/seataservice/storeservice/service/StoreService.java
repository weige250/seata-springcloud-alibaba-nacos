package com.zskj.microservice.seataservice.storeservice.service;

import com.zskj.microservice.seataservice.storeservice.entiy.Kucun;
import org.springframework.stereotype.Service;

public interface StoreService {
    /*
    * param-productid ：产品id
    * param-decnum: 消减数量
     */
    public void updatestore(Long productid, int decnum);

    public Kucun selectStoreByProductid(Long productid);
}
