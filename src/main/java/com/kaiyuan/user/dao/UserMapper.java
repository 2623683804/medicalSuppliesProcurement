package com.kaiyuan.user.dao;

import com.kaiyuan.user.entity.Permission;
import com.kaiyuan.user.entity.SupplieDetails;
import com.kaiyuan.user.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

     SysUser findByUserName(String username);

     boolean addGysUserOne(@Param("username")String username,@Param("password")String password);
     int addGysUserTwo(SupplieDetails supplieDetails);
     int addRole(@Param("Sys_User_id")Integer Sys_User_id);
     int updateGysUserSt(@Param("gysid")Integer gysid,@Param("username")String username);

     SupplieDetails queryGlyid(String CompanyName);

     SysUser findByUserId(String username);
}
