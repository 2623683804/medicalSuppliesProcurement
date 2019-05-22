package com.kaiyuan.user.service;

import com.kaiyuan.user.dao.UserMapper;
import com.kaiyuan.user.entity.SupplieDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserService implements UserServiceImpl{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public boolean addGysUserOne(String username,String password){
        logger.info(username+","+password);
        userMapper.addGysUserOne(username,password);
        Integer i = userMapper.findByUserId(username).getId();
        return userMapper.addRole(i)==1;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public boolean addGysUserTwo(SupplieDetails supplieDetails,String username){
        userMapper.addGysUserTwo(supplieDetails);
        logger.info(supplieDetails.getCompanyName());
        Integer i=userMapper.queryGlyid(supplieDetails.getCompanyName()).getGysid();
        logger.info(i.toString());
        return userMapper.updateGysUserSt(i,username) == 1;

    }

    @Override
    public SupplieDetails queryGysAll(String username){

        return userMapper.queryGysAll(username);
    }

    @Override
    public boolean updateSupplieDetails(SupplieDetails supplieDetails, String username){
        return userMapper.updateSupplieDetails(supplieDetails,username)==1;
    }

    @Override
    public boolean updatePassword(String username,String password){
        return userMapper.updatePassword(username,password)==1;
    }

}
