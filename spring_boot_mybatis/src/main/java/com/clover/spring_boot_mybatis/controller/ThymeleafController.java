package com.clover.spring_boot_mybatis.controller;

import com.clover.spring_boot_mybatis.bean.Resource;
import com.clover.spring_boot_mybatis.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("th")
public class ThymeleafController {

    @Autowired
    Resource resource;

    @RequestMapping("/index")
    public String index(ModelMap map) {

        User user = new User();
        user.setId(1);
        user.setUsername("admin111");
        user.setPassword("123456");
        user.setBirthday(new Date());
        user.setDesc("啦啦啦啦啦啦！");

        map.addAttribute("resource", resource);
        map.addAttribute("user", user);
        return "thymeleaf/index";
    }

    @RequestMapping("/form")
    public String form(ModelMap map) {
        return "thymeleaf/form";
    }

//    @PostMapping("/postForm")
//    public String postForm(User user) {
//        System.out.println(user.getUsername());
//
//        return "redirect:/th/test";
//    }
}
