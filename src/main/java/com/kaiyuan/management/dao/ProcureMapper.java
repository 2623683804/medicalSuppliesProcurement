package com.kaiyuan.management.dao;

import com.kaiyuan.management.entity.CustomMedicasupplies;
import com.kaiyuan.management.entity.MedicalInformation;
import com.kaiyuan.management.entity.Medicasupplies;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProcureMapper {

    List<String> querymMedName();

    //根据条件查询总条数
    int queryCount(Map<String, Object> map);

    //根据条件分页
    List<CustomMedicasupplies> queryfyList(Map<String, Object> map);

    Integer medicalInfoId(String name);
    boolean addMedicalInformation(Medicasupplies medicasupplies);

    boolean updateMedicaSupplies(Medicasupplies medicasupplies);
    boolean deleteMedicaSupplies(Integer id);

    boolean updateStatus(Integer id);
}
