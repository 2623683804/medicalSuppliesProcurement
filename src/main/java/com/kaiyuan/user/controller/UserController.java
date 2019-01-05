package com.kaiyuan.user.controller;

import com.kaiyuan.user.entity.User;
import com.kaiyuan.user.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController //证明是Controller层，并且返回json
public class UserController {
    //依赖注入
    @Resource
    private UserService service;
    @RequestMapping(value = "/cs")
    public List<User> cs() {

        List<User> users = service.selectUserAll();
        return users;
    }
}
