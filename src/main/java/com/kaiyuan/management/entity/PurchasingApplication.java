package com.kaiyuan.management.entity;

import java.util.Date;

public class PurchasingApplication {

    private Integer id;
    private Integer mesu_id;
    private String companyName;
    private String gysmoney;
    private String status;
    private Date create_time;
    private Date update_time;

    public PurchasingApplication() {
    }

    public PurchasingApplication(Integer id, Integer mesu_id, String companyName, String gysmoney, String status, Date create_time, Date update_time) {
        this.id = id;
        this.mesu_id = mesu_id;
        this.companyName = companyName;
        this.gysmoney = gysmoney;
        this.status = status;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMesu_id() {
        return mesu_id;
    }

    public void setMesu_id(Integer mesu_id) {
        this.mesu_id = mesu_id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getGysmoney() {
        return gysmoney;
    }

    public void setGysmoney(String gysmoney) {
        this.gysmoney = gysmoney;
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
        return "PurchasingApplication{" +
                "id=" + id +
                ", mesu_id=" + mesu_id +
                ", companyName='" + companyName + '\'' +
                ", gysmoney='" + gysmoney + '\'' +
                ", status='" + status + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
