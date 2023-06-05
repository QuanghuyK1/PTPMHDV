package com.xemphim.WebXemPhim.controller;

import java.io.IOException;
import java.text.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xemphim.WebXemPhim.dto.NewDTO;
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
//    @GetMapping("accounts/{accountName}")
//    public ResponseEntity<APIResponse> getUser() {
//        APIResponse apiResponse = adminService.getAccounts();
//        return ResponseEntity
//                .status(apiResponse.getStatus())
//                .body(apiResponse);
//    }
    @GetMapping("accounts")
    public ResponseEntity<APIResponse> getAccounts() {
        APIResponse apiResponse = adminService.getAccounts();
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

    @GetMapping("producer")
    public void getProducer(HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.getProducer(request, response);
    }
    @GetMapping("nation")
    public void getNation(HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.getNation(request, response);
    }
    @GetMapping("director")
    public void getDirector (HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.getDirector(request, response);
    }
    //Thêm
    @PostMapping("director/{new}")
    public void addDirector (@PathVariable(value = "new") String newDir,HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.addDirector(newDir,request, response);
    }
    @PostMapping("nation/{new}")
    public void addNation (@PathVariable(value = "new") String newNation, HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.addNation(newNation,request, response);
    }
    @PostMapping("producer/{new}")
    public void addProducer (@PathVariable(value = "new") String newPro,HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.addProducer(newPro,request, response);
    }
    //Sửa
    @PostMapping("director/{id}/{new}")
    public void renameDirector (@PathVariable(value = "id") int id,
                             @PathVariable(value = "new") String newDir,
                             HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.renameDirector(id,newDir,request, response);
    }
    @PostMapping("nation/{id}/{new}")
    public void renameNation (@PathVariable(value = "id") int id,
                           @PathVariable(value = "new") String newNation,
                           HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.renameNation(id,newNation,request, response);
    }
    @PostMapping("producer/{id}/{new}")
    public void renameProducer (@PathVariable(value = "id") int id,
                             @PathVariable(value = "new") String newPro,
                             HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.renameProducer(id,newPro,request, response);
    }

    //Xóa
    @PostMapping("director/delete/{id}")
    public void deleteDirector (@PathVariable(value = "id") int id,
                                @PathVariable(value = "new") String newDir,
                                HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.deleteDirector(id,request, response);
    }
    @PostMapping("nation/delete/{id}")
    public void deleteNation (@PathVariable(value = "id") int id,
                              @PathVariable(value = "new") String newNation,
                              HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.deleteNation(id,request, response);
    }
    @PostMapping("producer/delete/{id}")
    public void deleteProducer (@PathVariable(value = "id") int id,
                                @PathVariable(value = "new") String newPro,
                                HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        adminService.deleteProducer(id,request, response);
    }
}
