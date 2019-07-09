package com.clover.spring_boot_mybatis.service;


import com.clover.spring_boot_mybatis.model.Student;

import java.util.List;


public interface StudentService {

    List<Student> getAllStudent();

    int insert(Student student);
}
