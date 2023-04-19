package com.xemphim.WebXemPhim.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xemphim.WebXemPhim.models.Account;

public interface AccountRepository extends JpaRepository<Account, String>{
	Account findOneByAccountNameAndPassword(String accountName, String password);

    Optional<Account> findOneByAccountName(String accountName);
}
