package com.stoop.api.utils;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import com.stoop.api.entities.User;

public class Authentication implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext facesContext = event.getFacesContext();
		String pageName = facesContext.getViewRoot().getViewId();

		System.out.println(pageName);

		if ("login.xhtml".equals(pageName)) {
			return;
		}

		User user = (User) facesContext.getExternalContext().getSessionMap().get("loggedUser");

		if (user != null) {
			return;
		}
		NavigationHandler handler = facesContext.getApplication().getNavigationHandler();
		handler.handleNavigation(facesContext, null, "/login?faces-redirect=true");

		facesContext.renderResponse();
	}

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
