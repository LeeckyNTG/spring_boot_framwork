package com.clover.spring_boot_mybatis.service;


import com.clover.spring_boot_mybatis.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    int insert(User user);

    int update();

    User getUserById(String userNo);
}
