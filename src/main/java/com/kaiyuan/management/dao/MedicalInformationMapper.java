package com.kaiyuan.management.dao;

import com.kaiyuan.management.entity.MedicalInformation;
import com.kaiyuan.management.entity.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MedicalInformationMapper {
     //根据条件查询总条数
     int queryCount(Map<String, Object> map);

     //List<MedicalInformation> findcxfyList(@Param("name") String name,@Param("user_id") String user_id, @Param("status")String status, @Param("startrow")int startrow);
     //根据条件分页
     List<MedicalInformation> queryfyList(Map<String, Object> map);

     //int findQueryl();

     boolean addMedicalInformation(MedicalInformation medicalInformation);

     boolean deleteMedical(Integer id);

     boolean updateMedicalInformation(MedicalInformation medicalInformation);


}
