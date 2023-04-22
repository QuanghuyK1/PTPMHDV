package com.xemphim.WebXemPhim.repositories;

import com.xemphim.WebXemPhim.models.Account;
import com.xemphim.WebXemPhim.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token,Integer> {
    List<Token> findAllValidTokenByAccount(Account account);
    Optional<Token> findFirstByAccountOrderByIdDesc(Optional<Account> account);
}
