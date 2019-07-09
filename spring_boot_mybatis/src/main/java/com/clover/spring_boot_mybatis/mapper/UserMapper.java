package com.clover.spring_boot_mybatis.mapper;

import com.clover.spring_boot_mybatis.model.User;

import java.util.List;

//@Mapper如果没有添加Mapper扫描就要加入
public interface UserMapper {
    int deleteByPrimaryKey(String userNo);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userNo);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAllUser();
}