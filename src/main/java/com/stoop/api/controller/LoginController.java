package com.stoop.api.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.stoop.api.dto.UserDTO;
import com.stoop.api.entities.User;
import com.stoop.api.service.impl.UserServiceImpl;

@ManagedBean
@ViewScoped
public class LoginController {

	@Autowired
	private UserServiceImpl service;

	private UserDTO user = new UserDTO();

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		User u = new User();
		u = service.findByUser(user.getUser());
		
		if(u.getPassword().equals(user.getPassword())) {
			context.getExternalContext().getSessionMap().put("loggedUser", u);
			return "ControllPainel?faces-redirect=true";
		}

		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null,  new FacesMessage("User not found"));
		return "login?faces-redirect=true";
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}
