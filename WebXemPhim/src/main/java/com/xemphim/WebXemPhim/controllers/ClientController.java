package com.xemphim.WebXemPhim.controllers;

import com.xemphim.WebXemPhim.common.APIResponse;
import com.xemphim.WebXemPhim.dto.ChangeInfoRequestDTO;
import com.xemphim.WebXemPhim.dto.ChangePasswordRequestDTO;
import com.xemphim.WebXemPhim.dto.CommentRequestDTO;
import com.xemphim.WebXemPhim.dto.EvaluationRequestDTO;
import com.xemphim.WebXemPhim.repositories.AccountRepository;
import com.xemphim.WebXemPhim.repositories.FilmPackageRepository;
import com.xemphim.WebXemPhim.service.AuthenticationService;
import com.xemphim.WebXemPhim.service.ClientService;
import com.xemphim.WebXemPhim.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("home")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private FilmPackageRepository repository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("purchase/{id}")
    public ResponseEntity<APIResponse> purchase(@PathVariable(value = "id") String id, HttpServletRequest request, HttpServletResponse response) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        String acc_Name = jwtService.extractAccountName(authHeader.substring(7));
        var account = accountRepository.findOneByAccountName(acc_Name);
        APIResponse apiResponse = clientService.purchase(repository.findOneByfilmPackageId(id),account);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }
    @GetMapping("film/category/{category}")
    public ResponseEntity<APIResponse> getFilmByCategory(@PathVariable(value="category") String category) {
        APIResponse apiResponse = clientService.GetFilmByCategory(category);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }
    @GetMapping("film/detail/{filmName}")
    public ResponseEntity<APIResponse> getDetailFilm(@PathVariable(value="filmName") String filmName) {
        APIResponse apiResponse = clientService.GetDetailFilm(filmName);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }
    @GetMapping("film/search/{filmName}")
    public ResponseEntity<APIResponse> getFilmsByName(@PathVariable(value="filmName") String filmName) {
        APIResponse apiResponse = clientService.GetFilmsByName(filmName);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }
    @GetMapping("info")
    public void getInfo(HttpServletRequest request, HttpServletResponse response) throws IOException  {
        clientService.getInfo(request, response);
    }
    @PostMapping("info/change-password")
    public void changePassword(@RequestBody ChangePasswordRequestDTO requestDTO,HttpServletRequest request,HttpServletResponse response) throws IOException  {
        authenticationService.changePassword(requestDTO, request, response);
    }
    @PostMapping("info/change-info")
    public void changeInfo(@RequestBody ChangeInfoRequestDTO requestDTO, HttpServletRequest request,HttpServletResponse response) throws IOException {
        authenticationService.changeInfo(requestDTO, request,response);
    }
    @GetMapping("info/status-pricing")
    public void getPackages(HttpServletRequest request, HttpServletResponse response) throws IOException  {
        clientService.getPackages(request, response);
    }
    @PostMapping("film/evaluate")
    public void evaluate(@RequestBody EvaluationRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException  {
        clientService.evaluate(requestDTO,request, response);
    }
    @PostMapping("film/comment")
    public void comment(@RequestBody CommentRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException  {
        clientService.comment(requestDTO,request, response);
    }
    @PostMapping("refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException  {
        authenticationService.refreshToken(request, response);
    }
}
