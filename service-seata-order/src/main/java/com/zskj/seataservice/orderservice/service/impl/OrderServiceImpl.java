package com.zskj.seataservice.orderservice.service.impl;

import com.zskj.seataservice.orderservice.dao.OrderinfoDao;
import com.zskj.seataservice.orderservice.entiy.Orderinfo;
import com.zskj.seataservice.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderservice")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderinfoDao orderinfoDao;

    @Transactional(rollbackFor = Exception.class)
    public Orderinfo createOrder(Long productId, int productnum) {

        if(productnum == 50){
            throw  new RuntimeException("模拟exception");
        }
        Orderinfo orderinfo = new Orderinfo();
        orderinfo.setProductid(productId);
        orderinfo.setProductnum(productnum);
        orderinfoDao.insertSelective(orderinfo);

        return orderinfo;
    }
}
