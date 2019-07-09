package com.clover.spring_boot_mybatis.service.impl;

import com.clover.spring_boot_mybatis.mapper.StudentMapper;
import com.clover.spring_boot_mybatis.model.Student;
import com.clover.spring_boot_mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> getAllStudent() {
        return studentMapper.selectAllStudent();
    }

    @Override
    public int insert(Student student) {
        return studentMapper.insert(student);
    }
}
