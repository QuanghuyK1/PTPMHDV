package com.xemphim.WebXemPhim.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class EvaluationDTO {
    private String accountName;
    private float rating;
    private String comment;
    @JsonFormat(pattern="yyyy-MM-dd HH-mm-ss",timezone="Asia/Ho_Chi_Minh")
    private Date time;

    public EvaluationDTO() {
    }

    public EvaluationDTO(String accountName, float rating, String comment, Date time) {
        this.accountName = accountName;
        this.rating = rating;
        this.comment = comment;
        this.time = time;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
