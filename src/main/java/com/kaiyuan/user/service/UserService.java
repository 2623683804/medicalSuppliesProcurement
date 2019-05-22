package com.kaiyuan.user.service;

import com.kaiyuan.user.config.JqGridReturn;
import com.kaiyuan.user.dao.UserMapper;
import com.kaiyuan.user.entity.SupplieDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserServiceImpl{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public boolean addGysUserOne(String username,String password){
        logger.info(username+","+password);
        userMapper.addGysUserOne(username,password);
        Integer i = userMapper.findByUserId(username).getId();
        return userMapper.addRole(i)==1;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public boolean addGysUserTwo(SupplieDetails supplieDetails,String username){
        userMapper.addGysUserTwo(supplieDetails);
        logger.info(supplieDetails.getCompanyName());
        Integer i=userMapper.queryGlyid(supplieDetails.getCompanyName()).getGysid();
        logger.info(i.toString());
        return userMapper.updateGysUserSt(i,username) == 1;

    }

    @Override
    public SupplieDetails queryGysAll(String username){

        return userMapper.queryGysAll(username);
    }

    @Override
    public boolean updateSupplieDetails(SupplieDetails supplieDetails, String username){
        return userMapper.updateSupplieDetails(supplieDetails,username)==1;
    }

    @Override
    public boolean updatePassword(String username, String password){
        return userMapper.updatePassword(username,password)==1;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public boolean deleteGys(Integer gysid){
        if (userMapper.deleteGysSupplie(gysid)){
            if ( userMapper.deleteGysUser(gysid)){
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public int querySupplieCount(Map<String, Object> map) {
        return userMapper.querySupplieCount(map);
    }



    @Override
    public List<SupplieDetails> querySupplieList(Map<String, Object> map) {
        return userMapper.querySupplieList(map);
    }

    /**
     * 分页查询
     * @return
     */
    @Override
    public JqGridReturn selectSupplie(Map<String, Object> map){

        List<SupplieDetails> list=userMapper.querySupplieList(map);
        JqGridReturn jq=new JqGridReturn();
        jq.setRows(list);
        logger.info(jq.getRows().toString());
        jq.setTotal(querySupplieCount(map));
        jq.setTotolPage((jq.getTotal()/jq.getPageSize()+1));
        return jq;

    }
}
