package com.xemphim.WebXemPhim.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xemphim.WebXemPhim.dto.AccountDTO;
import com.xemphim.WebXemPhim.service.AccountService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/login")
	public boolean Login(@RequestBody @Valid AccountDTO accountDTO) {
		return accountService.findById(accountDTO);
	}
}
