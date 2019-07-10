package com.clover.spring_boot_dubbo_provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.clover.dubbo.model.Student;
import com.clover.dubbo.service.StudentService;
import com.clover.spring_boot_dubbo_provider.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;

//SpringBoot的Service
@org.springframework.stereotype.Service
//dubbo的Service
@Service(version = "1.0.0", timeout = 10000)
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public String sayHello() {
        return "Hi,SpringBoot!";
    }

    @Override
    public Student getStudent(int id) {
        return studentMapper.selectStudentById(id);
    }
}
