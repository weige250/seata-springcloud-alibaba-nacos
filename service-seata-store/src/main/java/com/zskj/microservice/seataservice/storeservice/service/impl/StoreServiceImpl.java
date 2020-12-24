package com.zskj.microservice.seataservice.storeservice.service.impl;

import com.zskj.microservice.seataservice.storeservice.dao.KucunDao;
import com.zskj.microservice.seataservice.storeservice.entiy.Kucun;
import com.zskj.microservice.seataservice.storeservice.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("storeservice")
public class StoreServiceImpl implements StoreService {
    @Autowired
    KucunDao kucunDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updatestore(Long productid, int decnum) {
        List<Kucun> datalist = kucunDao.selectByProductId(productid);
        Kucun kucun  = datalist.get(0);
        kucun.setCount(kucun.getCount() - decnum);

        kucunDao.updateByPrimaryKey(kucun);
    }

    @Override
    public Kucun selectStoreByProductid(Long productid) {
        List<Kucun> datalist = kucunDao.selectByProductId(productid);
        Kucun kucun = null;
        if(datalist !=null && datalist.size()>0){
            kucun = datalist.get(0);
        }

        return kucun;
    }
}
