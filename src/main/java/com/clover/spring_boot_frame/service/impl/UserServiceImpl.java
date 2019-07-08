package com.clover.spring_boot_frame.service.impl;

import com.clover.spring_boot_frame.mapper.UserMapper;
import com.clover.spring_boot_frame.po.User;
import com.clover.spring_boot_frame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        List<User> users = userMapper.selectAllUser();
        return users;
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }


    @Transactional
    @Override
    public int update() {
        User user = new User();
        user.setUserNo("2");
        user.setUserName("admin");
        int re = userMapper.updateByPrimaryKeySelective(user);
        System.out.println("更新结果" + re);
        int a = 10 / 0;
        return re;
    }
}
