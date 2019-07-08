package com.clover.spring_boot_frame.mapper;

import com.clover.spring_boot_frame.po.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectAllStudent();

}