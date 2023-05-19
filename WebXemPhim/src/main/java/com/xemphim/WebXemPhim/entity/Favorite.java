package com.xemphim.WebXemPhim.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "favorites")
public class Favorite {
    @EmbeddedId
    private FavoriteID id;

//    @Column(name = "favorite_cre_at")
//    @JsonFormat(pattern="yyyy-MM-dd HH-mm-ss",timezone="Asia/Ho_Chi_Minh")
//    private Date creAt;

    public FavoriteID getId() {
        return id;
    }

    public void setId(FavoriteID id) {
        this.id = id;
    }

//    public Date getCreAt() {
//        return creAt;
//    }
//
//    public void setCreAt(Date creAt) {
//        this.creAt = creAt;
//    }
}
