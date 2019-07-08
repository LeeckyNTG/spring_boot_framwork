package com.clover.spring_boot_frame.service;

import com.clover.spring_boot_frame.po.Student;

import java.util.List;


public interface StudentService {

    List<Student> getAllStudent();

    int insert(Student student);
}
