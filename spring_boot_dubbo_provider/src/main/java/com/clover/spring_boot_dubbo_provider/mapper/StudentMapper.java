package com.clover.spring_boot_dubbo_provider.mapper;


import com.clover.dubbo.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    int insert(Student record);

    int insertSelective(Student record);

    Student selectStudentById(int id);

    List<Student> selectAllStudent();
}