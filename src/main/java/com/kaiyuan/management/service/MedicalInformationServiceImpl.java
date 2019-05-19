package com.kaiyuan.management.service;

import com.kaiyuan.management.entity.MedicalInformation;
import com.kaiyuan.management.entity.Page;
import com.kaiyuan.user.config.JqGridReturn;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface MedicalInformationServiceImpl {

//    int queryAll(String name, String user_id, String status);
//    int queryAll();

//    List<MedicalInformation> querycxfyList(MedicalInformation medicalInformation, Page p);

    int queryCount(Map<String, Object> map);

    List<MedicalInformation> queryfyList(Map<String, Object> map);

    JqGridReturn selectMedical(Map<String, Object> map);

    boolean add(MedicalInformation medicalInformation) throws ParseException;

    boolean deleteMedical(Integer id);

    boolean update(MedicalInformation medicalInformation);

 //   List<MedicalInformation> queryfyList(Page p);

//    List<MedicalInformation> querycxfyList(String name, String user_id, String status, int startrow,int pagesize);
}
