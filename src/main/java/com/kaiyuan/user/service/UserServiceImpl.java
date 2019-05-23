package com.kaiyuan.user.service;

import com.kaiyuan.user.config.JqGridReturn;
import com.kaiyuan.user.entity.SupplieDetails;
import com.kaiyuan.user.entity.SysUser;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface UserServiceImpl {
    boolean addGysUserOne(String username,String password);
    boolean addGysUserTwo(SupplieDetails supplieDetails,String username);

    SupplieDetails queryGysAll(String username);

    boolean updateSupplieDetails(SupplieDetails supplieDetails, String username);

    boolean updatePassword(String username, String password);

    boolean deleteGys(Integer gysid);

    int querySupplieCount(Map<String, Object> map);

    List<SupplieDetails> querySupplieList(Map<String, Object> map);

    JqGridReturn selectSupplie(Map<String, Object> map);

    int queryGlyCount(Map<String, Object> map);

    List<SysUser> queryGlyList(Map<String, Object> map);

    JqGridReturn selectGlyList(Map<String, Object> map);

    @Transactional(propagation= Propagation.REQUIRED)
    boolean deleteGlyUser(Integer id);

    boolean addGly(SysUser sysUser);

    boolean updateGly(SysUser sysUser);
}
