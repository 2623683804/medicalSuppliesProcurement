package com.kaiyuan.management.controller;

import com.kaiyuan.management.entity.MedicalInformation;
import com.kaiyuan.management.entity.Medicasupplies;
import com.kaiyuan.management.entity.Page;
import com.kaiyuan.management.service.ProcureService;
import com.kaiyuan.user.config.JqGridReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.expression.Maps;

import javax.annotation.Resource;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProcureController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private ProcureService procureService;

//    @RequestMapping("/getMedicalNameList")
//    @ResponseBody
//    public List<String>  getMedicalNameList(){
//        List<String> sjm=procureService.querymMedName();
//        logger.info(sjm.toString());
//        return sjm;
//    }

    // 进入到医用品页面的初始化
    @GetMapping("/administrator/procurement")
    public String medicalsupplies(Model model, HttpServletRequest request){
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
        String delivery_time = request.getParameter("delivery_time");
        String name = request.getParameter("name");
        String status = request.getParameter("status");
        map.put("delivery_time",delivery_time);
        map.put("status",status);
        map.put("name",name);
        map.put("p",p);
        JqGridReturn jq = procureService.selectMedical(map);
        if (null == p){
            logger.info("p=null");
        }else {
            jq.setP(Integer.parseInt(p));
        }

        model.addAttribute("jq",jq);//list Total TotolPage
        List<String> sjm=procureService.querymMedName();
        logger.info(sjm.toString());
        model.addAttribute("sjm",sjm);
//        model.addAttribute("user_id",user_id);
        return "administrator/procurement";
    }



    @PostMapping(value = "/addOrupdatemedical")
    public String addAndUpdate(Model model, Medicasupplies medicasupplies,String name) {
        String Cname = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
        medicasupplies.setUser_id(Cname);
        if (medicasupplies.getStatus()==null){
            medicasupplies.setStatus("1");
        }
        List<Medicasupplies> meList;
        if (medicasupplies.getId()==null){
            if (procureService.addMedicalInformation(medicasupplies,name)){
                return "redirect:/administrator/procurement";
            }else {
                logger.info("添加失败");
                model.addAttribute("msg","添加失败");
                return "administrator/procurement";
            }
        }else{
            if (procureService.updateMedicaSupplies(medicasupplies,name)){
                return "redirect:/administrator/procurement";
            }else {
                logger.info("修改失败");
                model.addAttribute("msg","修改失败");
                return "administrator/procurement";
            }
        }
    }
    @GetMapping("/deletemedicalsupplies/{id}")
    public ModelAndView deleteMedical(@PathVariable("id") Integer id) {
        procureService.deleteMedicaSupplies(id);
        return new ModelAndView("redirect:/administrator/procurement");//重定向到list页面
    }
    @RequestMapping("/updateStatus/{id}")
    public ModelAndView updateStatus(@PathVariable("id") Integer id) {
        procureService.updateStatus(id);
        return new ModelAndView("redirect:/administrator/procurement");//重定向到list页面
    }

}
