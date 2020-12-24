package com.zskj.microservice.servicemongo.repository.impl;

import com.zskj.microservice.servicemongo.entiy.Student;
import com.zskj.microservice.servicemongo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class StudentRepositoryImpl implements StudentRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Student findStudentByname(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query,Student.class);
    }

    public void saveStudent(Student student) {
        mongoTemplate.save(student);
    }

    public void deleteStudent(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        mongoTemplate.remove(query,Student.class);
    }

    public void updateStudent(Student student) {
        Query query = new Query(Criteria.where("name").is(student.getName()));
        Update update = new Update().set("age",student.getAge()).set("sex",student.getSex());
        mongoTemplate.updateFirst(query,update,Student.class);
    }
}
