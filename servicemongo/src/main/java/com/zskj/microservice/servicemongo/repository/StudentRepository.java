package com.zskj.microservice.servicemongo.repository;

import com.zskj.microservice.servicemongo.entiy.Student;

public interface StudentRepository {
    public Student findStudentByname(String name);
    public void saveStudent(Student student);
    public void deleteStudent(String name);
    public void updateStudent(Student student);
}
