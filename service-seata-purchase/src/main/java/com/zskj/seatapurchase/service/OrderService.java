package com.zskj.seatapurchase.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-seata-order")
public interface OrderService {
    @PostMapping("/neworder")
    String createOrder(@RequestParam("productid") Long productid, @RequestParam("productnum") int productnum);
}
