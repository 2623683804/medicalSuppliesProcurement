package com.kaiyuan.user.controller;

import com.kaiyuan.user.entity.User;
import com.kaiyuan.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller //@RestController证明是Controller层，并且返回json
public class UserController {
    //依赖注入
    @Resource
    private UserService service;
    @RequestMapping(value = "/list")
    public String cs(Model model) {

        List<User> users = service.selectUserAll();
        model.addAttribute("users",users);
        return "/user/list";
    }
}
