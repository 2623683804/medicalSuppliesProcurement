package com.kaiyuan.user.entity;

public class SupplieDetails {
    private Integer gysid;
    private String companyName;
    private String zzjgNumber;
    private String tyshNumber;
    private String tax_number;
    private String account_number;
    private String legal_name;
    private String legal_number;
    private String business_contact;
    private String bu_contact_phone;
    private String bank;
    private String bank_number;
    private String address;

    public SupplieDetails() {
    }

    public SupplieDetails(Integer gysid, String companyName, String zzjgNumber, String tyshNumber, String tax_number, String account_number, String legal_name, String legal_number, String business_contact, String bu_contact_phone, String bank, String bank_number, String address) {
        this.gysid = gysid;
        this.companyName = companyName;
        this.zzjgNumber = zzjgNumber;
        this.tyshNumber = tyshNumber;
        this.tax_number = tax_number;
        this.account_number = account_number;
        this.legal_name = legal_name;
        this.legal_number = legal_number;
        this.business_contact = business_contact;
        this.bu_contact_phone = bu_contact_phone;
        this.bank = bank;
        this.bank_number = bank_number;
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getGysid() {
        return gysid;
    }

    public void setGysid(Integer gysid) {
        this.gysid = gysid;
    }

    public String getZzjgNumber() {
        return zzjgNumber;
    }

    public void setZzjgNumber(String zzjgNumber) {
        this.zzjgNumber = zzjgNumber;
    }

    public String getTyshNumber() {
        return tyshNumber;
    }

    public void setTyshNumber(String tyshNumber) {
        this.tyshNumber = tyshNumber;
    }

    public String getTax_number() {
        return tax_number;
    }

    public void setTax_number(String tax_number) {
        this.tax_number = tax_number;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getLegal_name() {
        return legal_name;
    }

    public void setLegal_name(String legal_name) {
        this.legal_name = legal_name;
    }

    public String getLegal_number() {
        return legal_number;
    }

    public void setLegal_number(String legal_number) {
        this.legal_number = legal_number;
    }

    public String getBusiness_contact() {
        return business_contact;
    }

    public void setBusiness_contact(String business_contact) {
        this.business_contact = business_contact;
    }

    public String getBu_contact_phone() {
        return bu_contact_phone;
    }

    public void setBu_contact_phone(String bu_contact_phone) {
        this.bu_contact_phone = bu_contact_phone;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBank_number() {
        return bank_number;
    }

    public void setBank_number(String bank_number) {
        this.bank_number = bank_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SupplieDetails{" +
                "gysid=" + gysid +
                ", zzjgNumber='" + zzjgNumber + '\'' +
                ", tyshNumber='" + tyshNumber + '\'' +
                ", tax_number='" + tax_number + '\'' +
                ", account_number='" + account_number + '\'' +
                ", legal_name='" + legal_name + '\'' +
                ", legal_number='" + legal_number + '\'' +
                ", business_contact='" + business_contact + '\'' +
                ", bu_contact_phone='" + bu_contact_phone + '\'' +
                ", bank='" + bank + '\'' +
                ", bank_number='" + bank_number + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
