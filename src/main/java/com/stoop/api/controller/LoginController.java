package com.stoop.api.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.stoop.api.dto.UserDTO;
import com.stoop.api.entities.User;
import com.stoop.api.service.impl.UserServiceImpl;

@Scope(value = "session")
@Component(value = "loginController")
@ELBeanName(value = "loginController")
@Join(path = "/", to = "/index.jsf")
public class LoginController {

	@Autowired
	private UserServiceImpl service;

	private UserDTO user = new UserDTO();

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		User u = new User();
		u = service.findByUser(user.getUser());
		if(u.getPassword().equals(user.getPassword())) {
			return "ControllPainel.xhtml?faces-redirect=true";
		}

		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null,  new FacesMessage("User not found"));
		return "index?faces-redirect=true";
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}
