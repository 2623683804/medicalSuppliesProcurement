package com.kaiyuan.management.service;

import com.kaiyuan.management.entity.CustomMedicasupplies;
import com.kaiyuan.management.entity.Medicasupplies;
import com.kaiyuan.user.config.JqGridReturn;

import java.util.List;
import java.util.Map;

public interface ProcureService {

    List<String> querymMedName();

    int queryCount(Map<String, Object> map);

    List<CustomMedicasupplies> queryfyList(Map<String, Object> map);

    JqGridReturn selectMedical(Map<String, Object> map);

    boolean addMedicalInformation(Medicasupplies medicasupplies,String name);

    boolean updateMedicaSupplies(Medicasupplies medicasupplies,String name);

    boolean deleteMedicaSupplies(Integer id);

    boolean updateStatus(Integer id);
}
