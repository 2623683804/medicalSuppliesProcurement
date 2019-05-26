package com.kaiyuan.management.entity;

public class SupplierApplication {
    private Integer id;
    private String number;
    private String rel_quotation;
    private String gysmoney;
    private String delivery_time;
    private String purapp_status;
    private String name;
    private String  meinfo_status;

    public SupplierApplication() {
    }

    public SupplierApplication(Integer id, String number, String rel_quotation, String gysmoney, String delivery_time, String purapp_status, String name, String meinfo_status) {
        this.id = id;
        this.number = number;
        this.rel_quotation = rel_quotation;
        this.gysmoney = gysmoney;
        this.delivery_time = delivery_time;
        this.purapp_status = purapp_status;
        this.name = name;
        this.meinfo_status = meinfo_status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getGysmoney() {
        return gysmoney;
    }

    public void setGysmoney(String gysmoney) {
        this.gysmoney = gysmoney;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }

    public String getPurapp_status() {
        return purapp_status;
    }

    public void setPurapp_status(String purapp_status) {
        this.purapp_status = purapp_status;
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

    @Override
    public String toString() {
        return "SupplierApplication{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", rel_quotation='" + rel_quotation + '\'' +
                ", gysmoney='" + gysmoney + '\'' +
                ", delivery_time='" + delivery_time + '\'' +
                ", purapp_status='" + purapp_status + '\'' +
                ", name='" + name + '\'' +
                ", meinfo_status='" + meinfo_status + '\'' +
                '}';
    }
}
