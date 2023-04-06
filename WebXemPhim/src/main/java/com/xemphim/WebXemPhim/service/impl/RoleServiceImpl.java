package com.xemphim.WebXemPhim.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xemphim.WebXemPhim.converter.RoleConverter;
import com.xemphim.WebXemPhim.dto.RoleDTO;
import com.xemphim.WebXemPhim.models.Role;
import com.xemphim.WebXemPhim.repositories.RoleRepository;
import com.xemphim.WebXemPhim.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleConverter roleConverter;
	
	@Override
	public List<RoleDTO> findAll() {
		List<RoleDTO> listRoleDTO = new ArrayList<>();
		List<Role> listRole = roleRepository.findAll();
		for (Role item: listRole) {
			RoleDTO roleDTO = roleConverter.toDTO(item);
			
			listRoleDTO.add(roleDTO);
		}
		return listRoleDTO;
	}

}
