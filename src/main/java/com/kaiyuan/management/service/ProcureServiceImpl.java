package com.kaiyuan.management.service;

import com.kaiyuan.management.dao.ProcureMapper;
import com.kaiyuan.management.entity.CustomMedicasupplies;
import com.kaiyuan.management.entity.Medicasupplies;
import com.kaiyuan.user.config.JqGridReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ProcureServiceImpl implements ProcureService{
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private ProcureMapper procureMapper;

    @Override//查询以用品名称集合
    public List<String> querymMedName(){
        return procureMapper.querymMedName();
    }


    @Override
    public int queryCount(Map<String, Object> map) {
        return procureMapper.queryCount(map);
    }

    @Override
    public List<CustomMedicasupplies> queryfyList(Map<String, Object> map) {
        return procureMapper.queryfyList(map);
    }

    /**
     * 分页查询
     * @return
     */
    @Override
    public JqGridReturn selectMedical(Map<String, Object> map){

        List<CustomMedicasupplies> list=procureMapper.queryfyList(map);
        JqGridReturn jq=new JqGridReturn();
        jq.setRows(list);
        jq.setTotal(queryCount(map));
        jq.setTotolPage((jq.getTotal()/jq.getPageSize()+1));
        return jq;

    }
    @Override
    public boolean addMedicalInformation(Medicasupplies medicasupplies,String name){
        medicasupplies.setMedtion_id(procureMapper.medicalInfoId(name));
        Date date=new Date();
        medicasupplies.setRelese_time(date);
        return procureMapper.addMedicalInformation(medicasupplies);
    }

    @Override
    public boolean updateMedicaSupplies(Medicasupplies medicasupplies,String name){
        medicasupplies.setMedtion_id(procureMapper.medicalInfoId(name));
        logger.info(medicasupplies.toString());
        return procureMapper.updateMedicaSupplies(medicasupplies);
    }
    @Override
    public boolean deleteMedicaSupplies(Integer id){
        //
        return procureMapper.deleteMedicaSupplies(id);
    }
    @Override
    public boolean updateStatus(Integer id){
        //
        return procureMapper.updateStatus(id);
    }
    @Override
    public boolean updateStatusFb(Integer id){
        //
        return procureMapper.updateStatusFb(id);
    }

    @Override
    public int queryfbCount(Map<String, Object> map) {
        return procureMapper.queryfbCount(map);
    }

    @Override
    public List<CustomMedicasupplies> queryfbList(Map<String, Object> map) {
        return procureMapper.queryfbList(map);
    }

    /**
     * 分页查询
     * @return
     */
    @Override
    public JqGridReturn selectfbList(Map<String, Object> map){

        List<CustomMedicasupplies> list=procureMapper.queryfbList(map);
        JqGridReturn jq=new JqGridReturn();
        jq.setRows(list);
        jq.setTotal(queryfbCount(map));
        jq.setTotolPage((jq.getTotal()/jq.getPageSize()+1));
        return jq;

    }

    @Override
    public JqGridReturn queryIndex(Map<String, Object> map){

        List<CustomMedicasupplies> list=procureMapper.queryfbList(map);
        JqGridReturn jq=new JqGridReturn();
        jq.setRows(list);
        return jq;

    }
}
