package com.kaiyuan.management.entity;

public class CustomMedicasupplies {
    private Integer id;
    private String name;
    private String meinfo_status;
    private String medic_status;
    private String number;
    private String rel_quotation;
    private String delivery_time;
    private String user_id;
    private String relese_time;
    public CustomMedicasupplies() {
    }

    public CustomMedicasupplies(Integer id, String name, String meinfo_status, String medic_status, String number, String rel_quotation, String delivery_time, String user_id, String relese_time) {
        this.id = id;
        this.name = name;
        this.meinfo_status = meinfo_status;
        this.medic_status = medic_status;
        this.number = number;
        this.rel_quotation = rel_quotation;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeinfo_status() {
        return meinfo_status;
    }

    public void setMeinfo_status(String meinfo_status) {
        this.meinfo_status = meinfo_status;
    }

    public String getMedic_status() {
        return medic_status;
    }

    public void setMedic_status(String medic_status) {
        this.medic_status = medic_status;
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

    public String getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRelese_time() {
        return relese_time;
    }

    public void setRelese_time(String relese_time) {
        this.relese_time = relese_time;
    }

    @Override
    public String toString() {
        return "CustomMedicasupplies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", meinfo_status='" + meinfo_status + '\'' +
                ", medic_status='" + medic_status + '\'' +
                ", number='" + number + '\'' +
                ", rel_quotation='" + rel_quotation + '\'' +
                ", delivery_time='" + delivery_time + '\'' +
                ", user_id='" + user_id + '\'' +
                ", relese_time='" + relese_time + '\'' +
                '}';
    }
}
