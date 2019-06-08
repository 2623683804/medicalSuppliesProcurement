package com.kaiyuan.management.service;

import com.kaiyuan.management.entity.MedicalInformation;
import com.kaiyuan.user.config.JqGridReturn;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface MedicalInformationServiceImpl {


    int queryCount(Map<String, Object> map);

    List<MedicalInformation> queryfyList(Map<String, Object> map);

    JqGridReturn selectMedical(Map<String, Object> map);

    boolean add(MedicalInformation medicalInformation) throws ParseException;

    boolean deleteMedical(Integer id);

    boolean update(MedicalInformation medicalInformation);

}
