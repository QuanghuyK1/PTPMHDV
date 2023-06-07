package com.xemphim.WebXemPhim.service;

import com.xemphim.WebXemPhim.common.APIResponse;
import com.xemphim.WebXemPhim.dto.NewDTO;
import com.xemphim.WebXemPhim.dto.request.*;
import com.xemphim.WebXemPhim.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.text.ParseException;

public interface AdminService {
    User addUser(User user);

    APIResponse getAccounts();
    void creFilm(@RequestBody CreFilmRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void creEpisodes(String filmName, CreEpisodeRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void deleteFilm(String filmName,HttpServletRequest request, HttpServletResponse response) throws IOException;

    void deleleEpisode(String filmName, String title, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void creCategory(String name, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void deleteCategory(String name, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void updateCategory(String oldName, String newName, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void creEpisodeLink(String filmName, CreEpisodeLinkRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void creFilmLink(CreFilmRequestLinkDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void updateEpisode(String filmId, String epiId, CreEpisodeLinkRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void updateFilm(String filmName, CreFilmRequestLinkDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException;

    void getProducer(HttpServletRequest request, HttpServletResponse response) throws IOException;
    void getNation(HttpServletRequest request, HttpServletResponse response) throws IOException;
    void getDirector (HttpServletRequest request, HttpServletResponse response) throws IOException;

    void addDirector(String newDir, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void addNation(String newNation, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void addProducer(String newPro, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void renameDirector(int id, String newDir, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void renameNation(int id, String newNation, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void renameProducer(int id, String newPro, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void deleteDirector(int id, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void deleteNation(int id, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void deleteProducer(int id, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void getActor(HttpServletRequest request, HttpServletResponse response) throws IOException;

    void addActor(String newDir, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void renameActor(int id, String newDir, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void creFilmLinkFile(CreFilm_FIle_Link_RequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void updateFilmFilePoster(String filmName, CreFilm_FIle_Link_RequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException;
}
