package com.xemphim.WebXemPhim.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xemphim.WebXemPhim.models.Account;

@RestController
@RequestMapping(path = "/api/account")
public class AccountController {
	
	@PostMapping
	public boolean createAccount(@RequestBody Account account) {
		return false;
	}
}
