package com.clover.spring_boot_frame.service;

import com.clover.spring_boot_frame.po.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    int insert(User user);

    int update();
}
