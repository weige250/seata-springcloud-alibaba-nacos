package com.zskj.seataservice.orderservice.service;

import com.zskj.seataservice.orderservice.entiy.Orderinfo;

public interface OrderService {
    public Orderinfo createOrder(Long productId, int productnum);

}
