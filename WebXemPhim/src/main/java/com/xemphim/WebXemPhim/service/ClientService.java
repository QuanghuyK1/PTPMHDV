package com.xemphim.WebXemPhim.service;

import com.xemphim.WebXemPhim.common.APIResponse;
import com.xemphim.WebXemPhim.dto.CommentRequestDTO;
import com.xemphim.WebXemPhim.dto.EvaluationRequestDTO;
import com.xemphim.WebXemPhim.models.Account;
import com.xemphim.WebXemPhim.models.FilmPackage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.Optional;

public interface ClientService {
    APIResponse GetDetailFilm(String nameFilm);
    APIResponse GetAllUser();
    APIResponse purchase(FilmPackage filmPackage, Optional<Account> account);
    APIResponse GetFilmByCategory(String category);
    APIResponse GetFilmsByName(String category);

    void getInfo(HttpServletRequest request, HttpServletResponse response) throws IOException;

    void getPackages(HttpServletRequest request, HttpServletResponse response) throws IOException;
    void evaluate(@RequestBody EvaluationRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response)throws IOException;

    void comment(CommentRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException;
}
