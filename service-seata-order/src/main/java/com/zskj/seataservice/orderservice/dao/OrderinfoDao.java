package com.zskj.seataservice.orderservice.dao;

import com.zskj.seataservice.orderservice.entiy.Orderinfo;

public interface OrderinfoDao {
    int deleteByPrimaryKey(Long id);

    int insert(Orderinfo record);

    int insertSelective(Orderinfo record);

    Orderinfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Orderinfo record);

    int updateByPrimaryKey(Orderinfo record);
}