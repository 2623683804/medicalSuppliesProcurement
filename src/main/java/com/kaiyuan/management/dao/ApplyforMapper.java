package com.kaiyuan.management.dao;


import com.kaiyuan.management.entity.CustomMedicasupplies;
import com.kaiyuan.management.entity.PurchasingApplication;
import com.kaiyuan.management.entity.SupplierApplication;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ApplyforMapper {

    CustomMedicasupplies queryApplyfor (Integer id);

    boolean addPurApp(PurchasingApplication purchasingApplication);

    String queryCompanyName(String username);

    int queryGysAppCount(Map<String, Object> map);
    List<SupplierApplication> queryGysApplication(Map<String, Object> map);

    boolean updateApplyfor(PurchasingApplication purchasingApplication);
    boolean updateStatusSC(Integer id);
    boolean updateStatusTJ(Integer id);
    boolean updateStatusBTG(Integer id);
    boolean updateStatusTG(Integer id);

    int querySpCount(Map<String, Object> map);
    List<SupplierApplication> querySpFy(Map<String, Object> map);

}
