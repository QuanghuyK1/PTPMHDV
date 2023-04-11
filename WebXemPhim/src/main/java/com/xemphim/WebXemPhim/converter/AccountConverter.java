package com.xemphim.WebXemPhim.converter;

import org.springframework.stereotype.Component;

import com.xemphim.WebXemPhim.dto.AccountDTO;
import com.xemphim.WebXemPhim.models.Account;

@Component
public class AccountConverter {
	public AccountDTO toDTO(Account account) {
		AccountDTO dto = new AccountDTO();
		if(account.getAccountName() != null) {
			dto.setAccountName(account.getAccountName());
			dto.setPassword(account.getPassword());
		}
		return dto;
	}
}
