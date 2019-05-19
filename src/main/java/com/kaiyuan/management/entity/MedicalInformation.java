package com.kaiyuan.management.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MedicalInformation {
    private Integer id;
    private String name;
    private String user_id;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date create_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date update_time;


    public MedicalInformation(Integer id, String name, String user_id, String status, Date create_time, Date update_time) {
        this.id = id;
        this.name = name;
        this.user_id = user_id;
        this.status = status;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public MedicalInformation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "MedicalInformation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user_id='" + user_id + '\'' +
                ", status='" + status + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
