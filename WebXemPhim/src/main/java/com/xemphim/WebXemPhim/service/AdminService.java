package com.xemphim.WebXemPhim.service;

import com.xemphim.WebXemPhim.common.APIResponse;
import com.xemphim.WebXemPhim.dto.request.CreEpisodeLinkRequestDTO;
import com.xemphim.WebXemPhim.dto.request.CreEpisodeRequestDTO;
import com.xemphim.WebXemPhim.dto.request.CreFilmRequestDTO;
import com.xemphim.WebXemPhim.dto.request.CreFilmRequestLinkDTO;
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

    void updateEpisode(String filmName, String oldTitle, CreEpisodeLinkRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void updateFilm(String filmName, CreFilmRequestLinkDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException;
}
