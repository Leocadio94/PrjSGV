package com.sistemavacinacao.controller;

import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sistemavacinacao.dao.IAccessDAO;
import com.sistemavacinacao.dao.impl.AccessDAOImpl;
import com.sistemavacinacao.entity.Access;

@ManagedBean
@SessionScoped
public class AccessMB implements Serializable {

	private static final long serialVersionUID = 6368841506864402238L;
	private Access currentAccess;
	private IAccessDAO accessDAO;

	public AccessMB() {
		currentAccess = new Access();
		accessDAO = new AccessDAOImpl();
	}

	public String login() {
		try {
			currentAccess = accessDAO.login(currentAccess);
			System.out.println(currentAccess);

			if (currentAccess == null) {
				currentAccess = new Access();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Usuário não encontrado ou senha inválida!", "Erro no Login!"));
				return null;
			} else {
				return "5_ADMtelaAutenticaLogin?faces-redirect=true";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Login inválido!", "Erro no Login!"));
			return null;
		}
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		currentAccess = new Access();
		accessDAO = new AccessDAOImpl();
		
		return "4_ADMtelaLogin?faces-redirect=true";
	}

	public IAccessDAO getAccessDAO() {
		return accessDAO;
	}

	public void setAccessDAO(IAccessDAO accessDAO) {
		this.accessDAO = accessDAO;
	}

	public Access getCurrentAccess() {
		return currentAccess;
	}
	
	public void setCurrentAccess(Access currentAccess) {
		this.currentAccess = currentAccess;
	}
}
