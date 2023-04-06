package com.xemphim.WebXemPhim.controllers.output;

import java.util.List;

import com.xemphim.WebXemPhim.dto.RoleDTO;

public class RoleOutput {
	private List<RoleDTO> listRole;

	public List<RoleDTO> getListRole() {
		return listRole;
	}

	public void setListRole(List<RoleDTO> list) {
		this.listRole = list;
	}
}
