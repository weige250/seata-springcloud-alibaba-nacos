package com.zskj.serviceconsumer.controller;

import com.zskj.serviceconsumer.service.SchooleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {
    @Autowired
    SchooleService schooleService;

    @GetMapping("/testgetname")
    private String getSchoolename(){
        String resut = schooleService.getName();
        return resut;
    }
}
