package com.xemphim.WebXemPhim.service;

import java.util.List;

import com.xemphim.WebXemPhim.dto.AccountDTO;

public interface AccountService {
	List<AccountDTO> findAll();
	boolean findById(AccountDTO accountDTO);
}
