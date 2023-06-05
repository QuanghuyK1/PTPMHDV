package com.xemphim.WebXemPhim.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AccountDTO {
    private String accountName;
    private String userName;
    private String role;
    private String email;
    private String phoneNumber;

    private int sex;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Ho_Chi_Minh")
    private Date birtdate;

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirtdate() {
        return birtdate;
    }

    public void setBirtdate(Date birtdate) {
        this.birtdate = birtdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
