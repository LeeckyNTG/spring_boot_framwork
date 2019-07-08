package com.clover.spring_boot_frame.mapper;

import com.clover.spring_boot_frame.po.User;

public interface UserMapper {
    int deleteByPrimaryKey(String userNo);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userNo);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}