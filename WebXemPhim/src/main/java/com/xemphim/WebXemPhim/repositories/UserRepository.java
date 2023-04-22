package com.xemphim.WebXemPhim.repositories;

import com.xemphim.WebXemPhim.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

    User findOneByEmailAndPhoneNumber(String email, String phoneNumber);
}
