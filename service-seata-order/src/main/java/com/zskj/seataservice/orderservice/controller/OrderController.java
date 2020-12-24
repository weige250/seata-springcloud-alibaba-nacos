package com.zskj.seataservice.orderservice.controller;

import com.zskj.seataservice.orderservice.entiy.Orderinfo;
import com.zskj.seataservice.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@Slf4j
@RestController
public class OrderController {

    private final static Logger logger = Logger.getLogger(OrderController.class.getName());

    @Autowired
    OrderService orderService;

    @PostMapping("/neworder")
    public String createOrder(Long productid, int productnum){
        String result = orderService.createOrder(productid,productnum).toString();
        logger.info(result);
        return result;
    }
}
