package com.xemphim.WebXemPhim.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xemphim.WebXemPhim.models.Account;
import com.xemphim.WebXemPhim.repositories.AccountRepository;
import com.xemphim.WebXemPhim.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	@Override
	public List<Account> findAll() {
		List<Account> entities = accountRepository.findAll();
		return entities;
	}

}
