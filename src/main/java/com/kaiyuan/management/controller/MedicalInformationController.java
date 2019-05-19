package com.kaiyuan.management.controller;


import com.kaiyuan.management.entity.MedicalInformation;
import com.kaiyuan.management.entity.Page;
import com.kaiyuan.management.service.MedicalInformationServiceImpl;
import com.kaiyuan.user.config.JqGridReturn;
import com.kaiyuan.user.controller.HomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MedicalInformationController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MedicalInformationServiceImpl medicalInformationServiceImpl;

    // 进入到医用品页面的初始化
    @RequestMapping("/administrator/medicalsupplies")
    public String medicalsupplies(Model model,Integer start,String user_id,String name,String status){

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
        JqGridReturn jq = medicalInformationServiceImpl.selectMedical(map);
        model.addAttribute("jq",jq);
        return "administrator/medicalsupplies";
    }

    //联合查询
//    @RequestMapping("/screening/medical")
//    public String doQuery(Model model,String user_id,String name,String status) {
//        //logger.info(medicalInformation.getName()+" "+medicalInformation.getUser_id()+" "+medicalInformation.getStatus());
//        logger.info(user_id+","+name+","+status);
//        Page page = new Page();// 创建一个表格信息对象
//        page.setPagesize(10);// 设置每页大小为10
//        page.setStartrow(0);// 设置开始查询的条数
//        page.setCurrentpage(1);// 设置当前页
//        logger.info("i=a");
//        int i= medicalInformationServiceImpl.queryAll(name,user_id,status);
//        logger.info("i=",i);
//        List<MedicalInformation> meList=medicalInformationServiceImpl.querycxfyList(name,user_id,status,page.getStartrow(),page.getPagesize());
//        logger.info("meList",meList==null);
//        page.setTotalrows(i);//总条数
//        //设置总页数   查询 总页数=总条数/页大小+1
//        page.setTotalpage((i % page.getPagesize() == 0) ? (i / page.getPagesize()) : (i / page.getPagesize() + 1));
//        model.addAttribute("p",page);
//        model.addAttribute("meList",meList);
//        return "administrator/medicalsupplies";
//    }

    @RequestMapping("/addorupdatemedical")
    public String addMedical(Model model,MedicalInformation medicalInformation) throws ParseException {
        Page p = new Page();
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

//    // 跳转尾页
//    @RequestMapping("/screening/queryEnd")
//    public String doQueryEnd(Model model) {
//        Page p = new Page();// 创建一个表格信息对象
//        p.setPagesize(10);// 设置每页大小为10
//
//        int i=medicalInformationServiceImpl.queryAll();
//        p.setTotalrows(i);// 设置总条数
//        int totalpage = (i % 10 == 0) ? (i / 10) : (i /10 + 1);// 查询 总页数=总条数/页大小+1
//        p.setStartrow((totalpage - 1) * 10);// 设置开始查询的条数
//        p.setTotalpage(totalpage);// 设置总页数
//        p.setCurrentpage(totalpage);// 设置当前页
//        List<MedicalInformation> meList = medicalInformationServiceImpl.queryfyList(p);// 获取整个表的记录
//        model.addAttribute("p",p);
//        model.addAttribute("meList",meList);
//        return "administrator/medicalsupplies";
//
//    }

//    // 跳转上/下一页
//    @RequestMapping("/screening/queryNext/{currentpage}")
//    public String doQueryNext(Model model, Page page, @PathVariable Integer currentpage) {
//        Page p = new Page();// 创建一个表格信息对象
//        p.setPagesize(10);// 设置每页大小为10
//        int i=medicalInformationServiceImpl.queryAll();
//        p.setTotalrows(i);// 设置总条数
//        int totalpage = (i % 10 == 0) ? (i / 10) : (i /10 + 1);// 查询 总页数=总条数/页大小+1
//        p.setCurrentpage(currentpage);// 设置当前页*
//        p.setStartrow((page.getCurrentpage() - 1) * 10);// 设置开始查询的条数
//        p.setTotalpage(totalpage);// 设置总页数
//        List<MedicalInformation> meList = medicalInformationServiceImpl.queryfyList(p);// 获取整个表的记录
//        model.addAttribute("p",p);
//        model.addAttribute("meList",meList);
//        return "administrator/medicalsupplies";
//
//    }
//
//    // 跳转其它页
//    @RequestMapping("/screening/queryJump")
//    public String doQueryJump(Model model , Page page) {
//
//        int jumppage = page.getJumppage();// 从前台获取将跳转的页
//
//        // 进入到此页面的初始化
//        Page p = page;// 创建一个表格信息对象
//        p.setPagesize(10);// 设置每页大小为10
//        int i=medicalInformationServiceImpl.queryAll();// 查询总条数
//        p.setTotalrows(i);// 设置总条数*
//        int totalpage = (i % 10 == 0) ? (i / 10) : (i /10 + 1);// 查询 总页数=总条数/页大小+1
//        p.setTotalpage(totalpage);// 设置总页数*
//        p.setStartrow((jumppage - 1) * 4);// 设置开始查询的条数
//        p.setCurrentpage(jumppage);// 将从前台获取将跳转的页设置成当前页*
//        List<MedicalInformation> meList = medicalInformationServiceImpl.queryfyList(p);// 获取整个表的记录
//        model.addAttribute("p",p);
//        model.addAttribute("meList",meList);
//        return "administrator/medicalsupplies";
//
//    }
}

