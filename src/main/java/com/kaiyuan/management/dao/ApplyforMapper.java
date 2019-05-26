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

    //根据条件查询总条数
    int queryGysAppCount(Map<String, Object> map);

    //根据条件分页
    List<SupplierApplication> queryGysApplication(Map<String, Object> map);
}
