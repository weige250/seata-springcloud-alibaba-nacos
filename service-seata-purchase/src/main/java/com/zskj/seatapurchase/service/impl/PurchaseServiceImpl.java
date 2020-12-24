package com.zskj.seatapurchase.service.impl;

import com.zskj.seatapurchase.controller.PurchaseController;
import com.zskj.seatapurchase.service.OrderService;
import com.zskj.seatapurchase.service.PurchaseService;
import com.zskj.seatapurchase.service.StoreService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Service("purchaseservice")
public class PurchaseServiceImpl implements PurchaseService {
    private final static Logger logger = Logger.getLogger(PurchaseServiceImpl.class.getName());
    @Autowired
    OrderService orderService;

    @Autowired
    StoreService storeService;

    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String buy(Long productid, int productnum,boolean enableException) {
        logger.info("start purchase");

        String kucuninfo = storeService.getKucun(productid);
        logger.info("before update : "+kucuninfo);

        storeService.updateKucun(productid,productnum);
        kucuninfo = storeService.getKucun(productid);
        logger.info("after update : "+kucuninfo);


        String result = orderService.createOrder(productid,productnum);
        logger.info(result);

        return "success";
        //return  "success";
    }
}
