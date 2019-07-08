package com.clover.spring_boot_frame.service.impl;

import com.clover.spring_boot_frame.mapper.StudentMapper;
import com.clover.spring_boot_frame.po.Student;
import com.clover.spring_boot_frame.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
