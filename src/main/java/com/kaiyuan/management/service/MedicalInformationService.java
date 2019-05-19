package com.kaiyuan.management.service;


import com.kaiyuan.management.dao.MedicalInformationMapper;
import com.kaiyuan.management.entity.MedicalInformation;
import com.kaiyuan.management.entity.Page;
import com.kaiyuan.user.config.JqGridReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class MedicalInformationService implements MedicalInformationServiceImpl {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MedicalInformationMapper medicalInformationMapper;

//    @Override
//    public int  queryAll(String name,String user_id,String status) {
//        return medicalInformationMapper.findQuery(name,user_id,status);
//    }

    @Override
    public int queryCount(Map<String, Object> map) {
        return medicalInformationMapper.queryCount(map);
    }

    @Override
    public List<MedicalInformation> queryfyList(Map<String, Object> map) {
        return medicalInformationMapper.queryfyList(map);
    }

    /**
     * 分页查询
     * @return
     */
    @Override
    public JqGridReturn selectMedical(Map<String, Object> map){

        List<MedicalInformation> list=medicalInformationMapper.queryfyList(map);
        JqGridReturn jq=new JqGridReturn();
        jq.setRows(list);
        jq.setTotal(queryCount(map));
        jq.setTotolPage((jq.getTotal()/jq.getPageSize()+1));
        return jq;

    }

    @Override
    public boolean add(MedicalInformation medicalInformation){
        Date date=new Date();
        medicalInformation.setCreate_time(date);
        medicalInformation.setUpdate_time(date);
        return medicalInformationMapper.addMedicalInformation(medicalInformation);
    }

    @Override
    public boolean deleteMedical(Integer id) {
        return medicalInformationMapper.deleteMedical(id);
    }

    @Override
    public boolean update(MedicalInformation medicalInformation) {
        Date date=new Date();
        medicalInformation.setUpdate_time(date);
        return medicalInformationMapper.updateMedicalInformation(medicalInformation);
    }



}
