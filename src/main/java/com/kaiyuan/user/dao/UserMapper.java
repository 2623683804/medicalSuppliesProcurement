package com.kaiyuan.user.dao;

import com.kaiyuan.user.entity.SupplieDetails;
import com.kaiyuan.user.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

     SysUser findByUserName(String username);

     void addGysUserOne(@Param("username")String username, @Param("password")String password);//boolean
     void addGysUserTwo(SupplieDetails supplieDetails);//int
     int addRole(@Param("Sys_User_id")Integer Sys_User_id);
     int updateGysUserSt(@Param("gysid")Integer gysid,@Param("username")String username);

     SupplieDetails queryGlyid(String CompanyName);

     SysUser findByUserId(String username);

     SupplieDetails queryGysAll(String username);

     int updateSupplieDetails(@Param("sup")SupplieDetails supplieDetails,@Param("username")String username);
     int updatePassword(@Param("username")String username,@Param("password")String password);
}
