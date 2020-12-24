package com.zskj.microservice.servicemongo.controller;

import com.zskj.microservice.servicemongo.entiy.Student;
import com.zskj.microservice.servicemongo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/get")
    public String testmongoget(String name){
        return studentRepository.findStudentByname(name).toString();
    }

    @GetMapping("/set")
    public String testmongoset(Student student){
        studentRepository.saveStudent(student);

        return studentRepository.findStudentByname(student.getName()).toString();
    }

    @GetMapping("/update")
    public String testmongoupdate(Student student){
        studentRepository.updateStudent(student);
        return studentRepository.findStudentByname(student.getName()).toString();
    }

    @GetMapping("/delete")
    public String testmongodelete(String name){
        studentRepository.deleteStudent(name);
        return studentRepository.findStudentByname(name).toString();
    }
}
