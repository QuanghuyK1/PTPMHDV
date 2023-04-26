package com.xemphim.WebXemPhim.service;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestBody;

import com.xemphim.WebXemPhim.common.APIResponse;
import com.xemphim.WebXemPhim.dto.request.CreFilmRequestDTO;
import com.xemphim.WebXemPhim.entity.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AdminService {
    User addUser(User user);

    APIResponse getUsers();
    void creFilm(@RequestBody CreFilmRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException;

}
