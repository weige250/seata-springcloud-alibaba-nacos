package com.zskj.microservice.seataservice.storeservice.controller;

import com.zskj.microservice.seataservice.storeservice.entiy.Kucun;
import com.zskj.microservice.seataservice.storeservice.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping("/get")
    public String getKucun(Long productid){
        return storeService.selectStoreByProductid(productid).toString();
    }

    @PostMapping("/update")
    public String updateKucun(Long productid, int decnum){
        storeService.updatestore(productid,decnum);

        return "success";
    }
}
