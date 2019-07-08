package com.clover.spring_boot_frame.controller;

import com.clover.spring_boot_frame.bean.JSONResult;
import com.clover.spring_boot_frame.bean.Resource;
import com.clover.spring_boot_frame.bean.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

//RestController=Controller + ResponseBody
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Resource resource;

    @RequestMapping("/getUser")
    public JSONResult getUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("admin111");
        user.setPassword("123456");
        user.setBirthday(new Date());
        user.setDesc("啦啦啦啦啦啦1111！");
        return JSONResult.ok(user);
    }

    //    @RequestMapping(value = "/getResource", method = RequestMethod.GET)
    @GetMapping(value = "/getResource")
    public JSONResult getResource() {

        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);
        return JSONResult.ok(bean);
    }

}
