package com.kaiyuan.management.controller;


import com.kaiyuan.management.entity.CustomMedicasupplies;
import com.kaiyuan.management.entity.PurchasingApplication;
import com.kaiyuan.management.service.ApplyforService;
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
import java.util.HashMap;
import java.util.Map;

@Controller
public class ApplyforController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private ApplyforService applyforService;

    @GetMapping("/applyfor/{id}")
    public String toApplyfor(Model model, @PathVariable("id") Integer id) {

        logger.info(id.toString());
        CustomMedicasupplies customMedicasupplies =applyforService.queryApplyfor(id);
        model.addAttribute("CustomMedicasupplies",customMedicasupplies) ;
        logger.info(customMedicasupplies.toString());
        return "applyfor";
    }

    @PostMapping("/addPurApp")
    public ModelAndView addPurApp(PurchasingApplication purchasingApplication){
        applyforService.addPurApp(purchasingApplication);
        return new ModelAndView("redirect:/usermanagement/purchasingrecords");
    }

    // 进入到申请页面的初始化
    @GetMapping("/usermanagement/purchasingrecords")
    public String medicalsupplies(Model model, HttpServletRequest request){
        String p = request.getParameter("p");
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
        String name = request.getParameter("name");
        String status = request.getParameter("status");

        map.put("status",status);
        map.put("name",name);
        map.put("p",p);
        JqGridReturn jq = applyforService.selectApplyfor(map);
        if (null == p){
            logger.info("p=null");
        }else {
            jq.setP(Integer.parseInt(p));
        }

        model.addAttribute("jq",jq);//list Total TotolPage
        return "usermanagement/purchasingrecords";
    }

    @GetMapping("/updateApplyfor")
    public ModelAndView updateApplyfor(PurchasingApplication purchasingApplication){

         applyforService.updateApplyfor(purchasingApplication);
        return new ModelAndView("redirect:/usermanagement/purchasingrecords");
    }

    @GetMapping("/updateStatusSC/{id}")//删除
    public ModelAndView updateStatusSC(@PathVariable("id") Integer id){
        applyforService.updateStatusSC(id);
        return new ModelAndView("redirect:/usermanagement/purchasingrecords");
    }

    @GetMapping("/updateStatusTJ/{id}")
    public ModelAndView updateStatusTJ(@PathVariable("id") Integer id){
        applyforService.updateStatusTJ(id);
        return new ModelAndView("redirect:/usermanagement/purchasingrecords");
    }
    @GetMapping("/updateStatusBTG/{id}")
    public ModelAndView updateStatusBTG(@PathVariable("id") Integer id){
        applyforService.updateStatusBTG(id);
        return new ModelAndView("redirect:/administrator/approval");
    }

    @GetMapping("/updateStatusTG/{id}")
    public ModelAndView updateStatusTG(@PathVariable("id") Integer id){
        applyforService.updateStatusTG(id);

        return new ModelAndView("redirect:/administrator/approval");
    }

    @GetMapping("/administrator/approval")
    public String approval(Model model, HttpServletRequest request){
        String p = request.getParameter("p");
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
        String name = request.getParameter("name");
        map.put("name",name);
        map.put("p",p);
        JqGridReturn jq = applyforService.selectSpFy(map);
        if (null == p){
            logger.info("p=null");
        }else {
            jq.setP(Integer.parseInt(p));
        }

        model.addAttribute("jq",jq);
        return "administrator/approval";
    }


}
