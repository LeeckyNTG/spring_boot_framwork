package com.clover.spring_boot_mybatis.controller;

import com.clover.spring_boot_mybatis.bean.JSONResult;
import com.clover.spring_boot_mybatis.model.Student;
import com.clover.spring_boot_mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {


    @Autowired
    StudentService studentService;

    @RequestMapping(value = "getStudentAll")
    public JSONResult getStudentAll() {
        List<Student> students = studentService.getAllStudent();
        return JSONResult.ok(students);
    }

    @RequestMapping(value = "insertStudent")
    public JSONResult insertStudent() {
        Student student = new Student();
        student.setName("余兰兰11");
        student.setAge(21);
        student.setTel("17329918983");
        student.setAddress("广州市番禺区");

        int result = studentService.insert(student);
        if (result > 0) {
            return JSONResult.ok();
        } else {
            return JSONResult.errorMap("插入信息失败！");
        }
    }

}
