package com.kaiyuan.user.controller;

import com.kaiyuan.user.config.JqGridReturn;
import com.kaiyuan.user.entity.SupplieDetails;
import com.kaiyuan.user.entity.SysUser;
import com.kaiyuan.user.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/administrator/supplier")
    public String supplier(Model model, HttpServletRequest request){
        String p = request.getParameter("p");
        logger.info("p="+p);
        String companyName = request.getParameter("companyName");
        logger.info("companyName="+companyName);
        Integer start;
        if (null == p){
            start=null;
        }else {
            start = Integer.parseInt(p);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        if (start!=null) {
            if (start<=0) {
                start=1;
            }
            map.put("start", (start-1)*10);
        }else{
            map.put("start", 0);
        }
        map.put("companyName",companyName);
        map.put("p",p);
        JqGridReturn jq = userService.selectSupplie(map);
        logger.info(jq.toString());
        if (null == p){
            logger.info("p=null");
        }else {
            jq.setP(Integer.parseInt(p));
        }
        model.addAttribute("jq",jq);//list Total TotolPage
        model.addAttribute("companyName",companyName);
        logger.info("XXXX");
        return "administrator/supplier";
    }

    @GetMapping("/deleteGys/{gysid}")
    public ModelAndView deleteGys(@PathVariable("gysid") Integer gysid) {
        userService.deleteGys(gysid);
        return new ModelAndView("redirect:/administrator/supplier");//重定向到list页面
    }


    @GetMapping("/administrator/gldministrator")
    public String userGly(Model model, HttpServletRequest request){
        String p = request.getParameter("p");
        logger.info("p="+p);
        Integer start;
        if (null == p){
            start=null;
        }else {
            start = Integer.parseInt(p);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        if (start!=null) {
            if (start<=0) {
                start=1;
            }
            map.put("start", (start-1)*10);
        }else{
            map.put("start", 0);
        }
        String username = request.getParameter("username");
        logger.info("username="+username);
        map.put("username",username);
        String glyLx = request.getParameter("glyLx");
        logger.info("glyLx="+glyLx);
        map.put("glyLx",glyLx);
        map.put("p",p);
        JqGridReturn jq = userService.selectGlyList(map);
        logger.info(jq.toString());
        if (null == p){
            logger.info("p=null");
        }else {
            jq.setP(Integer.parseInt(p));
        }
        model.addAttribute("jq",jq);//list Total TotolPage
        model.addAttribute("username",username);
        model.addAttribute("glyLx",glyLx);
        return "administrator/gldministrator";
    }

    @PostMapping(value = "/addAndUpdateGly")
    public String addAndUpdateGly(Model model, SysUser sysUser) throws ParseException {
        List<SysUser> meList;
        if (sysUser.getId()==null){
            if (userService.addGly(sysUser)){
                return "redirect:/administrator/gldministrator";
            }else {
                logger.info("添加失败");
                model.addAttribute("msg","添加失败");
                return "administrator/gldministrator";
            }
        }else{
            if (userService.updateGly(sysUser)){
                return "redirect:/administrator/gldministrator";
            }else {
                logger.info("修改失败");
                model.addAttribute("msg","修改失败");
                return "administrator/gldministrator";
            }
        }

    }

    @GetMapping("/deleteGly/{id}")
    public ModelAndView deleteGly(@PathVariable("id") Integer id) {
        userService.deleteGlyUser(id);
        return new ModelAndView("redirect:/administrator/gldministrator");//重定向到list页面
    }

}
