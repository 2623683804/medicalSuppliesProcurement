package com.kaiyuan.user.service;

import com.kaiyuan.user.entity.SupplieDetails;

public interface UserServiceImpl {
    boolean addGysUserOne(String username,String password);
    boolean addGysUserTwo(SupplieDetails supplieDetails,String username);
}
