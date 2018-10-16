package com.stoop.api.dto;

import com.stoop.api.enums.Role;

public class UserDTO {

	private Long id;
	private String user;
	private String password;
	private Role roleEnum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRoleEnum() {
		return roleEnum;
	}

	public void setRoleEnum(Role roleEnum) {
		this.roleEnum = roleEnum;
	}

}
