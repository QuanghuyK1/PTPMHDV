package com.xemphim.WebXemPhim.dto;

import com.xemphim.WebXemPhim.entity.Episode;

import java.util.Date;
import java.util.ArrayList;

public class FilmDTO {
    private String filmName;
    private String filmPosterPath;
    private ArrayList<String> filmCategory;
    private float filmRating;
//Detail
    private String filmDescription;
    private String trailerPath;
    private Integer odd;
    private Date release_time;
    private ArrayList<String> episodes;


    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmPosterPath() {
        return filmPosterPath;
    }

    public void setFilmPosterPath(String filmPosterPath) {
        this.filmPosterPath = filmPosterPath;
    }

    public ArrayList<String> getFilmCategory() {
        return filmCategory;
    }

    public void setFilmCategory(ArrayList<String> filmCategory) {
        this.filmCategory = filmCategory;
    }

    public float getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(float filmRating) {
        this.filmRating = filmRating;
    }

    public String getFilmDescription() {
        return filmDescription;
    }

    public void setFilmDescription(String filmDescription) {
        this.filmDescription = filmDescription;
    }

    public String getTrailerPath() {
        return trailerPath;
    }

    public void setTrailerPath(String trailerPath) {
        this.trailerPath = trailerPath;
    }

    public Integer getOdd() {
        return odd;
    }

    public void setOdd(Integer odd) {
        this.odd = odd;
    }

    public Date getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Date release_time) {
        this.release_time = release_time;
    }

    public ArrayList<String> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(ArrayList<String> episodes) {
        this.episodes = episodes;
    }
}
