package com.kaiyuan.user.dao;

import com.kaiyuan.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
     List<User> selectUserAll();
}
