package com.kaiyuan.user.entity;

import java.util.List;

public class SysUser {
    private Integer id;
    private String username;
    private String password;
    private String gysid;
    private String glylx;
    private String status;
    private List<SysRole> roles;

    public SysUser() {
    }

    public SysUser(Integer id, String username, String password, String gysid, String glylx, String status, List<SysRole> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gysid = gysid;
        this.glylx = glylx;
        this.status = status;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGysid() {
        return gysid;
    }

    public void setGysid(String gysid) {
        this.gysid = gysid;
    }

    public String getGlylx() {
        return glylx;
    }

    public void setGlylx(String glylx) {
        this.glylx = glylx;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gysid='" + gysid + '\'' +
                ", glylx='" + glylx + '\'' +
                ", status='" + status + '\'' +
                ", roles=" + roles +
                '}';
    }
}
