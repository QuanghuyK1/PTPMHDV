package com.xemphim.WebXemPhim.dto;

public class EpisodeDTO {
    private String title;
    private String path;
    private String creAt;


    public EpisodeDTO(String title, String path) {
        this.title = title;
        this.path = path;
    }

    public EpisodeDTO(String title, String path, String creAt) {
        this.title = title;
        this.path = path;
        this.creAt = creAt;
    }

    public String getCreAt() {
        return creAt;
    }

    public void setCreAt(String creAt) {
        this.creAt = creAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
