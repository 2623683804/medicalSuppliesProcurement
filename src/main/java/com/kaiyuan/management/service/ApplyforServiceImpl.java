package com.kaiyuan.management.service;

import com.kaiyuan.management.dao.ApplyforMapper;
import com.kaiyuan.management.entity.CustomMedicasupplies;
import com.kaiyuan.management.entity.PurchasingApplication;
import com.kaiyuan.management.entity.SupplierApplication;
import com.kaiyuan.user.config.JqGridReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ApplyforServiceImpl implements ApplyforService{
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private ApplyforMapper applyforMapper;

    @Override
    public CustomMedicasupplies queryApplyfor(Integer id){
        logger.info("ApplyforServiceImpl");
        return applyforMapper.queryApplyfor(id);
    }

    @Override
    public boolean addPurApp(PurchasingApplication purchasingApplication){
        String username = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
        purchasingApplication.setCompanyName(applyforMapper.queryCompanyName(username));
        Date date=new Date();
        purchasingApplication.setCreate_time(date);
        return applyforMapper.addPurApp(purchasingApplication);
    }

    @Override
    public int queryGysAppCount(Map<String, Object> map) {
        return applyforMapper.queryGysAppCount(map);
    }

    @Override
    public List<SupplierApplication> queryGysApplication(Map<String, Object> map) {
        return applyforMapper.queryGysApplication(map);
    }

    /**
     * 分页查询
     * @return
     */
    @Override
    public JqGridReturn selectApplyfor(Map<String, Object> map){
        String username = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
        map.put("companyName",applyforMapper.queryCompanyName(username));
        applyforMapper.queryCompanyName(username);
        List<SupplierApplication> list=applyforMapper.queryGysApplication(map);
        JqGridReturn jq=new JqGridReturn();
        jq.setRows(list);
        jq.setTotal(queryGysAppCount(map));
        jq.setTotolPage((jq.getTotal()/jq.getPageSize()+1));
        return jq;
    }
    @Override
    public boolean updateApplyfor(PurchasingApplication purchasingApplication){
        return applyforMapper.updateApplyfor(purchasingApplication);
    }
    @Override
    public boolean updateStatusSC(Integer id){
        return applyforMapper.updateStatusSC(id);
    }
    @Override
    public boolean updateStatusTJ(Integer id){
        return applyforMapper.updateStatusTJ(id);
    }
    @Override
    public boolean updateStatusBTG(Integer id){
        return applyforMapper.updateStatusBTG(id);
    }
    @Override
    public boolean updateStatusTG(Integer id){
        return applyforMapper.updateStatusTG(id);
    }

    @Override
    public int querySpCount(Map<String, Object> map) {
        return applyforMapper.querySpCount(map);
    }

    @Override
    public List<SupplierApplication> querySpFy(Map<String, Object> map) {
        return applyforMapper.querySpFy(map);
    }

    /**
     * 分页查询
     * @return
     */
    @Override
    public JqGridReturn selectSpFy(Map<String, Object> map){

        List<SupplierApplication> list=applyforMapper.querySpFy(map);
        JqGridReturn jq=new JqGridReturn();
        jq.setRows(list);
        jq.setTotal(querySpCount(map));
        jq.setTotolPage((jq.getTotal()/jq.getPageSize()+1));
        return jq;
    }

}
