package com.xemphim.WebXemPhim.repositories;

import com.xemphim.WebXemPhim.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String>{
    Optional<Account> findOneByAccountName(String accountName);
}
