package com.zskj.seatapurchase.controller;

import com.zskj.seatapurchase.service.OrderService;
import com.zskj.seatapurchase.service.PurchaseService;
import com.zskj.seatapurchase.service.StoreService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@Slf4j
@RestController
public class PurchaseController {
    private final static Logger logger = Logger.getLogger(PurchaseController.class.getName());

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/neworder")
    public String purchase(Long productid,int productnum){

       return  purchaseService.buy(productid,productnum,false);

    }
}
