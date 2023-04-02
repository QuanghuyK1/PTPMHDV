package com.xemphim.WebXemPhim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xemphim.WebXemPhim.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
