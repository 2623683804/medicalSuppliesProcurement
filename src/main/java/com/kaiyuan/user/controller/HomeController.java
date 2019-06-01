package com.kaiyuan.user.controller;


import com.kaiyuan.management.service.ProcureService;
import com.kaiyuan.user.config.JqGridReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private ProcureService procureService;


    @RequestMapping("/")
    public String indexL(Model model){
        logger.info("/->index");
        return "index";
    }
//    @RequestMapping("/whoim")
//    @ResponseBody
//    public Object whoIm(){
//        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    }
    @RequestMapping("/index")
    public String index(Model model){
        Map<String, Object> map = new HashMap<String, Object>();
        JqGridReturn jq = procureService.queryIndex(map);
        model.addAttribute("jq",jq);
        return "index";
    }

    @RequestMapping("/login")
    public  String login(){
        return "member/login";
    }
    @RequestMapping("/member/login")
    public  String memberlogin(){
        return "member/login";
    }



    @RequestMapping("/milestone")
    public String milestone(){
        return "milestone";
    }

    @RequestMapping("/member/register")
    public String register(){
        return "member/register";
    }

    @GetMapping("/member/tymcompany/{username}")
    public String tymcompany(Model model, @PathVariable("username") String username){
        logger.info("/member/tymcompany/{username}");
        model.addAttribute("username",username);
        return "member/tymcompany";
    }

    @GetMapping("/member/zchcompany/{username}")
    public String zchcompany(Model model, @PathVariable("username") String username){
        logger.info("/member/zchcompany/{username}");
        model.addAttribute("username",username);
        return "member/zchcompany";
    }


    @RequestMapping("/usermanagement/purchasingrecords")
    public String purchasingrecords(){
        return "usermanagement/purchasingrecords";
    }



}
