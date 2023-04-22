package com.xemphim.WebXemPhim.repositories;

import com.xemphim.WebXemPhim.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer>{

     Role findOneByRoleNameIgnoreCase(String roleName);
}
