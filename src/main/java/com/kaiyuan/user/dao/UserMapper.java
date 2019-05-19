package com.kaiyuan.user.dao;

import com.kaiyuan.user.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

     SysUser findByUserName(String username);



}
