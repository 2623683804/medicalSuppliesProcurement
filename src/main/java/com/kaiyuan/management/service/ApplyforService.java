package com.kaiyuan.management.service;

import com.kaiyuan.management.entity.CustomMedicasupplies;
import com.kaiyuan.management.entity.PurchasingApplication;
import com.kaiyuan.management.entity.SupplierApplication;
import com.kaiyuan.user.config.JqGridReturn;

import java.util.List;
import java.util.Map;

public interface ApplyforService {

    CustomMedicasupplies queryApplyfor(Integer id);

    boolean addPurApp(PurchasingApplication purchasingApplication);

    int queryGysAppCount(Map<String, Object> map);

    List<SupplierApplication> queryGysApplication(Map<String, Object> map);

    JqGridReturn selectApplyfor(Map<String, Object> map);

    boolean updateApplyfor(PurchasingApplication purchasingApplication);

    boolean updateStatusSC(Integer id);

    boolean updateStatusTJ(Integer id);

    boolean updateStatusBTG(Integer id);

    boolean updateStatusTG(Integer id);

    int querySpCount(Map<String, Object> map);

    List<SupplierApplication> querySpFy(Map<String, Object> map);

    JqGridReturn selectSpFy(Map<String, Object> map);
}
