package com.zskj.seatapurchase.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="service-seata-store")
public interface StoreService {
    @GetMapping("/get")
    String getKucun(@RequestParam("productid") Long productid);

    @PostMapping("/update")
    String updateKucun(@RequestParam("productid") Long productid, @RequestParam("decnum") int decnum);
}
