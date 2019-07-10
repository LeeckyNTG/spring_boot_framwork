package com.clover.spring_boot_dubbo_consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.clover.dubbo.model.Student;
import com.clover.dubbo.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "student")
public class StudentController {

    @Reference(version = "1.0.0")
    private StudentService studentService;

    @RequestMapping(value = "getStudent")
    public Object getStudent(@RequestParam("id") Integer id) {

        Student student = studentService.getStudent(id);

        return student;
    }

    @RequestMapping(value = "sayHi")
    public Object sayHi() {

        String msg = studentService.sayHello();

        return msg;
    }

}
