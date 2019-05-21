package com.kaiyuan.user.controller;

import com.kaiyuan.user.entity.SupplieDetails;
import com.kaiyuan.user.service.UserService;
import com.kaiyuan.user.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserServiceImpl userService;

    @PostMapping(value = "/addGysUserOne" )
    public String addGysUserOne(Model model,String username, String password){
        logger.info(username+","+password);
        if(userService.addGysUserOne(username, password)){
            model.addAttribute("username",username);
            return "member/tymcompany";
        }else{
            model.addAttribute("msg","重新注册");
            return "member/register";
        }
    }
    @RequestMapping("/addGysUserTwo")
    public String addGysUserTwo(Model model, String username, SupplieDetails supplieDetails){
        logger.info("addGysUserTwo--username="+username);
        if(userService.addGysUserTwo(supplieDetails, username)){
            return "redirect:member/login";
        }else{
            model.addAttribute("msg","重新填写");
            return "member/tymcompany";
        }
    }

}
