package com.kaiyuan.user.controller;


import com.kaiyuan.management.entity.MedicalInformation;
import com.kaiyuan.management.entity.Page;
import com.kaiyuan.management.service.MedicalInformationServiceImpl;
import com.kaiyuan.user.entity.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MedicalInformationServiceImpl medicalInformationServiceImpl;

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
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public  String login(){
        return "member/login";
    }

    @RequestMapping("/applyfor")
    public String applyfor(){
        return "applyfor";
    }

    @RequestMapping("/milestone")
    public String milestone(){
        return "milestone";
    }

    @RequestMapping("/member/register")
    public String register(){
        return "member/register";
    }

    @RequestMapping("/administrator/approval")
    public String approval(){
        return "administrator/approval";
    }

    @RequestMapping("/administrator/procurement")
    public String procurement(){
        return "administrator/procurement";
    }



    @RequestMapping("/administrator/gldministrator")
    public String gldministrator(){
        return "administrator/gldministrator";
    }


    @RequestMapping("/administrator/supplier")
    public String supplier(){
        return "administrator/supplier";
    }

    @RequestMapping("/usermanagement/purchasingrecords")
    public String purchasingrecords(){
        return "purchasingrecords";
    }

}
