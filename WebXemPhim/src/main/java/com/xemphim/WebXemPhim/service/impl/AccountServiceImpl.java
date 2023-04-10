package com.xemphim.WebXemPhim.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xemphim.WebXemPhim.converter.AccountConverter;
import com.xemphim.WebXemPhim.dto.AccountDTO;
import com.xemphim.WebXemPhim.models.Account;
import com.xemphim.WebXemPhim.repositories.AccountRepository;
import com.xemphim.WebXemPhim.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	AccountConverter accountConverter;
	
	@Override
	public List<AccountDTO> findAll() {
		List<AccountDTO> listAccountDTO = new ArrayList<>();
		List<Account> listAccounts = accountRepository.findAll();
		for(Account item: listAccounts) {
			AccountDTO accountDTO = new AccountDTO();
			accountDTO = accountConverter.toDTO(item);
			listAccountDTO.add(accountDTO);
		}
		return listAccountDTO;
	}

	@Override
	public boolean findById(AccountDTO accountDTO) {
		Optional<Account> account = accountRepository.findById(accountDTO.getAccountName());
		if (account.isEmpty()) return false;
		if (account.get()
				.getPassword()
				.equals(accountDTO.getPassword()))
			return true;
		return false;
	}

}
