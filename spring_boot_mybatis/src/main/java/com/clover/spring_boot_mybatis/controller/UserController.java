package com.clover.spring_boot_mybatis.controller;

import com.clover.spring_boot_mybatis.bean.JSONResult;
import com.clover.spring_boot_mybatis.bean.Resource;
import com.clover.spring_boot_mybatis.model.User;
import com.clover.spring_boot_mybatis.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    @RequestMapping("/getAllUserThreadPool")
    public JSONResult getAllUserThreadPool() {

        ExecutorService executorService = Executors.newFixedThreadPool(25);
        for (int i=0;i<100;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    List<User> users = userService.getAllUser();
                }
            });
        }

        return JSONResult.ok();
    }


    @RequestMapping("/getUserById/{id}")
    public JSONResult getUserById(@PathVariable("id") String id) {
        User user = userService.getUserById(id);
        return JSONResult.ok(user);
    }


    @RequestMapping("/updateUser")
    public JSONResult updateUser(User user) {
        System.out.println(user.getUserName());
        System.out.println(user.getUserNo());
        System.out.println(user.getUserPwd());
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

        System.out.println("------111----");

        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);
        return JSONResult.ok(bean);
    }

}
