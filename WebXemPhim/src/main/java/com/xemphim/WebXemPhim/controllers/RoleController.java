package com.xemphim.WebXemPhim.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xemphim.WebXemPhim.controllers.output.RoleOutput;
import com.xemphim.WebXemPhim.service.RoleService;

@CrossOrigin
@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping(value = "/role")
	public RoleOutput showRole() {
		RoleOutput result = new RoleOutput();
		result.setListRole(roleService.findAll());
		return result;
	}
}
