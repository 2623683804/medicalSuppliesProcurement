package com.kaiyuan.user.dao;

import com.kaiyuan.user.entity.SupplieDetails;
import com.kaiyuan.user.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

     boolean deleteGysSupplie(Integer gysid);
     boolean deleteGysUser(Integer gysid);

     //管理员根据条件查询总条数
     int querySupplieCount(Map<String, Object> map);

    //管理员根据条件分页
     List<SupplieDetails> querySupplieList (Map<String, Object> map);

}
