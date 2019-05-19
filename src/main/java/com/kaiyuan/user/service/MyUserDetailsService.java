package com.kaiyuan.user.service;

import com.kaiyuan.user.dao.PermissionMapper;
import com.kaiyuan.user.dao.UserMapper;

import com.kaiyuan.user.entity.Permission;
import com.kaiyuan.user.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyibo on 17/1/18.
 */
@Service
public class MyUserDetailsService implements UserDetailsService { //自定义UserDetailsService 接口

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermissionMapper permissionMapper ;

    public UserDetails loadUserByUsername(String username) {
        logger.info("输入username");
        SysUser user = userMapper.findByUserName(username);
        logger.info(user.getPassword()+user.getUsername()+user.getRoles());
        if (user != null) {
            List<Permission> permissions = permissionMapper.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList <>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName()!=null) {

                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

}
