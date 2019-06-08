package com.kaiyuan.management.controller;


import com.kaiyuan.management.entity.MedicalInformation;
import com.kaiyuan.management.service.MedicalInformationServiceImpl;
import com.kaiyuan.user.config.JqGridReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MedicalInformationController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private MedicalInformationServiceImpl medicalInformationServiceImpl;

    // 进入到医用品页面的初始化
    @GetMapping("/administrator/medicalsupplies")
    public String medicalsupplies(Model model, HttpServletRequest request){
        String p = request.getParameter("p");
        logger.info("p="+p);
        Integer start;
        if (null == p){
            start=null;
        }else {
            start = Integer.parseInt(p);
        }

        String user_id = request.getParameter("user_id");
        String name = request.getParameter("name");
        String status = request.getParameter("status");
        Map<String, Object> map = new HashMap<String, Object>();
        if (start!=null) {
            if (start<=0) {
                start=1;
            }
            map.put("start", (start-1)*10);
        }else{
           map.put("start", 0);
       }
        map.put("user_id",user_id);
        map.put("name",name);
        map.put("status",status);
        map.put("p",p);
        JqGridReturn jq = medicalInformationServiceImpl.selectMedical(map);
        if (null == p){
            logger.info("p=null");
        }else {
            jq.setP(Integer.parseInt(p));
        }

        model.addAttribute("jq",jq);//list Total TotolPage
        model.addAttribute("user_id",user_id);
        model.addAttribute("name",name);
        model.addAttribute("status",status);
        return "administrator/medicalsupplies";
    }


    @PostMapping(value = "/addorupdatemedical")
    public String addMedical(Model model,MedicalInformation medicalInformation) throws ParseException {
        List<MedicalInformation> meList;
        if (medicalInformation.getId()==null){
            if (medicalInformationServiceImpl.add(medicalInformation)){
                return "redirect:/administrator/medicalsupplies";
            }else {
                logger.info("添加失败");
                model.addAttribute("msg","添加失败");
                return "administrator/medicalsupplies";
            }
        }else{
            if (medicalInformationServiceImpl.update(medicalInformation)){
                return "redirect:/administrator/medicalsupplies";
            }else {
                logger.info("修改失败");
                model.addAttribute("msg","修改失败");
                return "administrator/medicalsupplies";
            }
        }

    }

    @GetMapping("/deleteMedical/{id}")
    public ModelAndView deleteMedical(@PathVariable("id") Integer id) {
        medicalInformationServiceImpl.deleteMedical(id);
        return new ModelAndView("redirect:/administrator/medicalsupplies");//重定向到list页面
    }


}

