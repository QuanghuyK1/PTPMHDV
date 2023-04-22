package com.xemphim.WebXemPhim.controllers;

import com.xemphim.WebXemPhim.common.APIResponse;
import com.xemphim.WebXemPhim.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping("users")
    public ResponseEntity<APIResponse> getAccounts() {
        APIResponse apiResponse = adminService.getUsers();
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }
}
