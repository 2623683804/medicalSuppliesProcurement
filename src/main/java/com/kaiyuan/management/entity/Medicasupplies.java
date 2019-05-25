package com.kaiyuan.management.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Medicasupplies {
    private Integer id;
    private Integer medtion_id;
    private String status;
    private String number;
    private String rel_quotation;
    private String sup_quotation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date delivery_time;
    private String user_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date relese_time;
    public Medicasupplies() {
    }

    public Medicasupplies(Integer id, Integer medtion_id, String status, String number, String rel_quotation, String sup_quotation, Date delivery_time, String user_id, Date relese_time) {
        this.id = id;
        this.medtion_id = medtion_id;
        this.status = status;
        this.number = number;
        this.rel_quotation = rel_quotation;
        this.sup_quotation = sup_quotation;
        this.delivery_time = delivery_time;
        this.user_id = user_id;
        this.relese_time = relese_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMedtion_id() {
        return medtion_id;
    }

    public void setMedtion_id(Integer medtion_id) {
        this.medtion_id = medtion_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRel_quotation() {
        return rel_quotation;
    }

    public void setRel_quotation(String rel_quotation) {
        this.rel_quotation = rel_quotation;
    }

    public String getSup_quotation() {
        return sup_quotation;
    }

    public void setSup_quotation(String sup_quotation) {
        this.sup_quotation = sup_quotation;
    }

    public Date getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(Date delivery_time) {
        this.delivery_time = delivery_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getRelese_time() {
        return relese_time;
    }

    public void setRelese_time(Date relese_time) {
        this.relese_time = relese_time;
    }

    @Override
    public String toString() {
        return "Medicasupplies{" +
                "id=" + id +
                ", medtion_id=" + medtion_id +
                ", status='" + status + '\'' +
                ", number='" + number + '\'' +
                ", rel_quotation='" + rel_quotation + '\'' +
                ", sup_quotation='" + sup_quotation + '\'' +
                ", delivery_time=" + delivery_time +
                ", user_id='" + user_id + '\'' +
                ", relese_time=" + relese_time +
                '}';
    }
}
