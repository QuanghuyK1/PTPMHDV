package com.xemphim.WebXemPhim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xemphim.WebXemPhim.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

}
