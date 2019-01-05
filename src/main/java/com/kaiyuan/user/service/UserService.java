package com.kaiyuan.user.service;

import com.kaiyuan.user.dao.UserMapper;
import com.kaiyuan.user.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class  UserService implements UserServiceI {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectUserAll() {
        return userMapper.selectUserAll();
    }
}
