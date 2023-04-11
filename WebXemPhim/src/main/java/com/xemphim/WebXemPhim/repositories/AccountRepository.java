package com.xemphim.WebXemPhim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xemphim.WebXemPhim.models.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

}
