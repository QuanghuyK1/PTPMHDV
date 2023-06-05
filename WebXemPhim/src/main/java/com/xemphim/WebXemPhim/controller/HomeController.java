package com.xemphim.WebXemPhim.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xemphim.WebXemPhim.output.PurchaseHistoryOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xemphim.WebXemPhim.common.APIResponse;
import com.xemphim.WebXemPhim.dto.request.ChangeInfoRequestDTO;
import com.xemphim.WebXemPhim.dto.request.ChangePasswordRequestDTO;
import com.xemphim.WebXemPhim.dto.request.CommentRequestDTO;
import com.xemphim.WebXemPhim.dto.request.EvaluationRequestDTO;
import com.xemphim.WebXemPhim.output.FilmPackageOutput;
import com.xemphim.WebXemPhim.repository.AccountRepository;
import com.xemphim.WebXemPhim.repository.FilmPackageRepository;
import com.xemphim.WebXemPhim.service.AuthenticationService;
import com.xemphim.WebXemPhim.service.ClientService;
import com.xemphim.WebXemPhim.service.JwtService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("home")
public class HomeController {
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

    @GetMapping("")
    public ResponseEntity<APIResponse> home() {
        APIResponse apiResponse = clientService.getHome();
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }

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
    @GetMapping("film/category/{category}/{pageNumber}")
    public ResponseEntity<APIResponse> getFilmByCategory(@PathVariable(value="category") String category,@PathVariable(value="pageNumber") int page) {
        APIResponse apiResponse = clientService.GetFilmByCategory(page,category);
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
    @GetMapping("film/search/{filmName}/{pageNumber}")
    public ResponseEntity<APIResponse> getFilmsByName(@PathVariable(value="filmName") String filmName,@PathVariable(value="pageNumber") int page) {
        APIResponse apiResponse = clientService.GetFilmsByName(page,filmName);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }
    @GetMapping("info")
    public void getInfo(HttpServletRequest request, HttpServletResponse response) throws IOException  {
        clientService.getInfo(request, response);
    }
    @GetMapping("category")
    public void getCategory(HttpServletRequest request, HttpServletResponse response) throws IOException  {
        clientService.getCategory(request, response);
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
    @PostMapping("film/evaluate/{filmName}")
    public void evaluate(@PathVariable(value="filmName") String filmName, @RequestBody EvaluationRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException  {
        clientService.evaluate(filmName, requestDTO,request, response);
    }
    @PostMapping("film/favorite/{filmName}")
    public void favorite(@PathVariable(value="filmName") String filmName, HttpServletRequest request, HttpServletResponse response) throws IOException  {
        clientService.favorite(filmName,request, response);
    }
    @PostMapping("film/comment")
    public void comment( @RequestBody CommentRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException  {
        clientService.comment(requestDTO,request, response);
    }
    @GetMapping("info/notify/{pageNumber}")
    public void getNotifyPagination(@PathVariable Integer pageNumber, HttpServletRequest request, HttpServletResponse response) throws IOException  {
        clientService.getNotifyPagination(pageNumber,request, response);
    }
    @GetMapping("info/film-packages")
    public List<FilmPackageOutput> getFilmPackages(){    	
    	return clientService.getFilmPackages();
    }
    @PostMapping("info/film-package-for-client/{accountName}")
    public void getFilmPackageForClient(@PathVariable(value="accountName") String accountName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        clientService.getFilmPackageForClient(accountName,request,response);
    }
    
    @PostMapping("info/purchase-history/{accountName}")
    public List<PurchaseHistoryOutput> getPurchaseHistory(@PathVariable(value="accountName") String accountName) {
    	List<Object[]> objects = new ArrayList<>();
    	objects = clientService.getPurchaseHistory(accountName);
    	if (objects.size() > 0){
    		List<PurchaseHistoryOutput> outputs = new ArrayList<>();
    		for (Object[] object: objects) {
    			PurchaseHistoryOutput output = new PurchaseHistoryOutput();
    			output.setUsed_time((Integer) object[0]);
    			output.setPurchaseDate((Date) object[1]);
    			output.setStartDate((Date) object[2]);
    			output.setExpirationDate((Date) object[3]);
                output.setStatus(Integer.valueOf(Integer.parseInt(object[4].toString())));
    			outputs.add(output);
    		}
    		return outputs;
    	}
    	return null;
    }
}
