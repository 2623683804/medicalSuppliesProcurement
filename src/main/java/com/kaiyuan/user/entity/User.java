package com.kaiyuan.user.entity;

public class User {
    private String id;
    private String id_type;
    private String id_card;
    private String phone;
    private String email;
    private String sex;
    private String birthday;
    private String office_phone;
    private String master_id;
    private String master_name;
    private String dept;
    private String position;
    private String position_desc;
    private String employees_card;
    private String hone_phone;
    private String create_time;
    private String update_time;
    private String logica_del;

    public User() {
        super();
    }

    public User(String id, String id_type, String id_card, String phone, String email, String sex, String birthday, String office_phone, String master_id, String master_name, String dept, String position, String position_desc, String employees_card, String hone_phone, String create_time, String update_time, String logica_del) {
        this.id = id;
        this.id_type = id_type;
        this.id_card = id_card;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
        this.birthday = birthday;
        this.office_phone = office_phone;
        this.master_id = master_id;
        this.master_name = master_name;
        this.dept = dept;
        this.position = position;
        this.position_desc = position_desc;
        this.employees_card = employees_card;
        this.hone_phone = hone_phone;
        this.create_time = create_time;
        this.update_time = update_time;
        this.logica_del = logica_del;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getOffice_phone() {
        return office_phone;
    }

    public void setOffice_phone(String office_phone) {
        this.office_phone = office_phone;
    }

    public String getMaster_id() {
        return master_id;
    }

    public void setMaster_id(String master_id) {
        this.master_id = master_id;
    }

    public String getMaster_name() {
        return master_name;
    }

    public void setMaster_name(String master_name) {
        this.master_name = master_name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition_desc() {
        return position_desc;
    }

    public void setPosition_desc(String position_desc) {
        this.position_desc = position_desc;
    }

    public String getEmployees_card() {
        return employees_card;
    }

    public void setEmployees_card(String employees_card) {
        this.employees_card = employees_card;
    }

    public String getHone_phone() {
        return hone_phone;
    }

    public void setHone_phone(String hone_phone) {
        this.hone_phone = hone_phone;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getLogica_del() {
        return logica_del;
    }

    public void setLogica_del(String logica_del) {
        this.logica_del = logica_del;
    }

    @Override
    public String toString() {
        return "user{" +
                "id='" + id + '\'' +
                ", id_type='" + id_type + '\'' +
                ", id_card='" + id_card + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", office_phone='" + office_phone + '\'' +
                ", master_id='" + master_id + '\'' +
                ", master_name='" + master_name + '\'' +
                ", dept='" + dept + '\'' +
                ", position='" + position + '\'' +
                ", position_desc='" + position_desc + '\'' +
                ", employees_card='" + employees_card + '\'' +
                ", hone_phone='" + hone_phone + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", logica_del='" + logica_del + '\'' +
                '}';
    }

}
