package com.clover.spring_boot_mybatis.service.impl;

import com.clover.spring_boot_mybatis.mapper.UserMapper;
import com.clover.spring_boot_mybatis.model.User;
import com.clover.spring_boot_mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Override
    public List<User> getAllUser() {

        //字符串系列化器
        RedisSerializer serializer = new StringRedisSerializer();
        //对key设置系列化
        redisTemplate.setKeySerializer(serializer);

        //解决高并发情况下多次查询数据库,缓存穿透问题
        List<User> users = (List<User>) redisTemplate.opsForValue().get("allUser");
        if (null == users) {
            synchronized (this){
                System.out.println("查询数据库");
                users = (List<User>) redisTemplate.opsForValue().get("allUser");
                if (users == null) {
                    users = userMapper.selectAllUser();
                    redisTemplate.opsForValue().set("allUser", users);
                }
            }
        }else {
            System.out.println("查询缓存");

        }

        return users;
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }


    /**
     * 事务配置
     *
     * @return
     */
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

    @Override
    public User getUserById(String userNo) {
        return userMapper.selectByPrimaryKey(userNo);
    }
}
