package com.kaiyuan.user.controller;

import com.kaiyuan.user.entity.SupplieDetails;
import com.kaiyuan.user.service.UserService;
import com.kaiyuan.user.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @RequestMapping("/usermanagement/account")
    public String account(Model model){
        String name = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
        SupplieDetails supplieDetails= userService.queryGysAll(name);
        model.addAttribute("supplieDetails",supplieDetails);
        return "usermanagement/account";
    }

    @RequestMapping("/updateSupplieDetails")
    public String updateSupplieDetails(Model model,SupplieDetails supplieDetails){
        String name = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
        logger.info(supplieDetails.toString());
        if (userService.updateSupplieDetails(supplieDetails,name)){
            model.addAttribute("msg","修改失败");
            return "redirect:usermanagement/account";
        }

        model.addAttribute("supplieDetails",supplieDetails);
        return "redirect:usermanagement/account";
    }

    @RequestMapping("/usermanagement/informationchanges")
    public String informationchanges(Model model){
        String name = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
        SupplieDetails supplieDetails= userService.queryGysAll(name);
        model.addAttribute("supplieDetails",supplieDetails);
        return "usermanagement/informationchanges";
    }

    @RequestMapping("/usermanagement/resetpassword")
    public String resetpassword(){
        return "usermanagement/resetpassword";
    }


    @RequestMapping("/updatePassword")
    public String updatePassword(Model model,String username,String bu_contact_phone,String password,String phoneCode){

        if ("0000".equals(phoneCode)){
            if ( userService.updatePassword(username,password)){
                //model.addAttribute("supplieDetails",supplieDetails);
                return "redirect:/logout";
            }else {
                model.addAttribute("username",username);
                model.addAttribute("bu_contact_phone",bu_contact_phone);
                return "usermanagement/resetpassword";
            }

        }else {
            model.addAttribute("username",username);
            model.addAttribute("bu_contact_phone",bu_contact_phone);
            return "usermanagement/resetpassword";
        }

    }
}
