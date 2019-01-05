package com.kaiyuan.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//标明这是个控制器，并自动返回json数据。
//Spring4之后新加入的注解，原来返回json需要@Responsebody和@Controller的配合
//相当于@Responsebody和@Controller的组合注解
public class TestController {
    @RequestMapping("helloworld")
    //作用在处理器方法上时应用到控制器的所有处理器方法上（映射）
    public  String testspringboot(){
        return "Hello world";
    }
}
