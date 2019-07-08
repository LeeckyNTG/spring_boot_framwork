package com.clover.spring_boot_frame.controller;

import com.clover.spring_boot_frame.bean.JSONResult;
import com.clover.spring_boot_frame.bean.Resource;
import com.clover.spring_boot_frame.po.User;
import com.clover.spring_boot_frame.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RestController=Controller + ResponseBody
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Resource resource;
    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUser")
    public JSONResult getAllUser() {
        List<User> users = userService.getAllUser();
        return JSONResult.ok(users);
    }

    @RequestMapping("/updateUser")
    public JSONResult updateUser() {
        int re = userService.update();
        return JSONResult.ok(re);
    }

    @RequestMapping("/insertUser")
    public JSONResult insertUser() {
        User user = new User();
        user.setUserNo("2");
        user.setUserName("admin");
        user.setUserPwd("123456");
        int result = userService.insert(user);
        if (result > 0) {
            return JSONResult.ok();
        } else {
            return JSONResult.errorMap("查询失败！");
        }

    }


    //    @RequestMapping(value = "/getResource", method = RequestMethod.GET)
    @GetMapping(value = "/getResource")
    public JSONResult getResource() {

        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);
        return JSONResult.ok(bean);
    }

}
