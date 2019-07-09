package com.clover.spring_boot_mybatis.mapper;

import com.clover.spring_boot_mybatis.model.Student;

import java.util.List;

public interface StudentMapper {
    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectAllStudent();
}