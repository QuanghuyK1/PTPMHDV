package com.xemphim.WebXemPhim.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.xemphim.WebXemPhim.common.APIResponse;
import com.xemphim.WebXemPhim.dto.request.CommentRequestDTO;
import com.xemphim.WebXemPhim.dto.request.EvaluationRequestDTO;
import com.xemphim.WebXemPhim.entity.Account;
import com.xemphim.WebXemPhim.entity.FilmPackage;
import com.xemphim.WebXemPhim.output.FilmPackageOutput;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ClientService {
    APIResponse GetDetailFilm(String nameFilm);
    APIResponse GetAllUser();
    APIResponse purchase(FilmPackage filmPackage, Optional<Account> account);
    APIResponse GetFilmByCategory(int page,String category);
    APIResponse GetFilmsByName(int page, String category);

    void getInfo(HttpServletRequest request, HttpServletResponse response) throws IOException;

    void getPackages(HttpServletRequest request, HttpServletResponse response) throws IOException;
    void evaluate(String filmName, @RequestBody EvaluationRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response)throws IOException;

    void comment(CommentRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException;
    void favorite(String filmName, HttpServletRequest request, HttpServletResponse response) throws IOException;
    APIResponse getHome();
    List<FilmPackageOutput> getFilmPackages();
    List<Object[]> getFilmPackageForClient(String acc_name);
    List<Object[]> getPurchaseHistory(String acc_name);
    void getNotifyPagination(Integer page, HttpServletRequest request, HttpServletResponse response) throws IOException;

    void getCategory(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
