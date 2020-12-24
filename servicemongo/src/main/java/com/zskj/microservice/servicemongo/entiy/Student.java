package com.zskj.microservice.servicemongo.entiy;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private String name;
    private String sex;
    private int age;
    private static final long serialVersionUID = -3258839839160856613L;
}
