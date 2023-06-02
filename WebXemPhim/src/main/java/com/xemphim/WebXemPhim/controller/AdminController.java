package com.xemphim.WebXemPhim.controller;

import java.io.IOException;
import java.text.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xemphim.WebXemPhim.dto.request.CreEpisodeLinkRequestDTO;
import com.xemphim.WebXemPhim.dto.request.CreEpisodeRequestDTO;
import com.xemphim.WebXemPhim.dto.request.CreFilmRequestLinkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.xemphim.WebXemPhim.common.APIResponse;
import com.xemphim.WebXemPhim.dto.request.CreFilmRequestDTO;
import com.xemphim.WebXemPhim.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("film/new")
    public void fileUpload(
            @ModelAttribute CreFilmRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response
            ) throws IOException {
        adminService.creFilm(requestDTO, request, response);
    }
    @PostMapping("film/newLink")
    public void creFilm(
            @RequestBody CreFilmRequestLinkDTO requestDTO, HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.creFilmLink(requestDTO, request, response);
    }
    @PostMapping("film/delete/{filmName}")
    public void deleteFilm( @PathVariable(value="filmName") String filmName,HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.deleteFilm(filmName,request, response);
    }
    @PostMapping("{filmName}/episode/delete/{title}")
    public void deleteEpisode( @PathVariable(value="filmName") String filmName,
                               @PathVariable(value="title") String title,
                               HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.deleleEpisode(filmName,title,request, response);
    }
    @PostMapping("{filmName}/episode/update/{title}")
    public void updateEpisode( @PathVariable(value="filmName") String filmName,
                               @PathVariable(value="title") String old_title,
                               @RequestBody CreEpisodeLinkRequestDTO requestDTO,
                               HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.updateEpisode(filmName,old_title,requestDTO,request, response);
    }
    @PostMapping("film/update/{filmName}")
    public void updateFilm( @PathVariable(value="filmName") String filmName,
                               @RequestBody CreFilmRequestLinkDTO requestDTO,
                               HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ParseException {
        adminService.updateFilm(filmName,requestDTO,request, response);
    }
    @PostMapping("{filmName}/episode/new")
    public void episodesUpload(
            @PathVariable(value="filmName") String filmName, @ModelAttribute CreEpisodeRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        if(requestDTO.getTitle() == null || requestDTO.getContent() == null){
            APIResponse apiResponse = new APIResponse();
            apiResponse.setStatus(400);
            apiResponse.setError("Cannot be null");
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
            return;
        }
        adminService.creEpisodes(filmName,requestDTO, request, response);
    }

    @PostMapping("{filmName}/episode/newLink")
    public void episodesLink(
            @PathVariable(value="filmName") String filmName, @RequestBody CreEpisodeLinkRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        if(requestDTO.getTitle() == null || requestDTO.getLink() == null){
            APIResponse apiResponse = new APIResponse();
            apiResponse.setStatus(400);
            apiResponse.setError("Cannot be null");
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
            return;
        }
        adminService.creEpisodeLink(filmName,requestDTO, request, response);
    }
    @GetMapping("users")
    public ResponseEntity<APIResponse> getAccounts() {
        APIResponse apiResponse = adminService.getUsers();
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }
    @PostMapping("category/new/{name}")
    public void addCategory(
            @PathVariable(value="name") String name, HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.creCategory(name, request, response);
    }
    @PostMapping("category/delete/{name}")
    public void deleteCategory(
            @PathVariable(value="name") String name, HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.deleteCategory(name, request, response);
    }
    @PostMapping("category/update/{old_name}/{new_name}")
    public void updateCategory(
            @PathVariable(value="old_name") String old_name, @PathVariable(value="new_name") String new_name, HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.updateCategory(old_name, new_name, request, response);
    }
}
