package com.zskj.microservice.seataservice.storeservice.dao;

import com.zskj.microservice.seataservice.storeservice.entiy.Kucun;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KucunDao {
    int deleteByPrimaryKey(Long id);

    int insert(Kucun record);

    int insertSelective(Kucun record);

    Kucun selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Kucun record);

    int updateByPrimaryKey(Kucun record);

    List<Kucun> selectByProductId(Long productid);
}