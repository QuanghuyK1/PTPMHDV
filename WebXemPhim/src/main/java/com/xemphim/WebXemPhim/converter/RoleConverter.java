package com.xemphim.WebXemPhim.converter;

import org.springframework.stereotype.Component;

import com.xemphim.WebXemPhim.dto.RoleDTO;
import com.xemphim.WebXemPhim.models.Role;

@Component
public class RoleConverter {
	public RoleDTO toDTO(Role role) {
		RoleDTO dto = new RoleDTO();
		if(role.getRoleId() != null) {
			dto.setRoleId(role.getRoleId());
		}
		dto.setRoleName(role.getRoleName());
		return dto;
	}
}
