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
import com.sistemavacinacao.entity.Person;

@ManagedBean
@SessionScoped
public class AccessMB implements Serializable {

	private static final long serialVersionUID = 6368841506864402238L;
	private Access currentAccess;
	private IAccessDAO accessDAO;

	public AccessMB() {
		currentAccess = new Access();
		currentAccess.setPerson(new Person());
		accessDAO = new AccessDAOImpl();
	}

	public static void main(String[] args) {
		Access access = new Access();
		access.setLogin("abc");
		access.setPassword("123");
		IAccessDAO aDAO = new AccessDAOImpl();
		Access test = aDAO.login(access);
		if (test == null) {
			test = new Access();
			System.out.println("Usuário não encontrado ou senha inválida!");
		} else {
			System.out.println("Login realizado com sucesso!");
		}
	}

	public String login() {
		System.out.println("I!M IN 2");
		currentAccess = accessDAO.login(currentAccess);

		if (currentAccess == null) {
			currentAccess = new Access();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Usuário não encontrado ou senha inválida!", "Erro no Login!"));
			return "";
		} else {
			return "5_ADMtelaAutenticaLogin?faces-redirect=true";
		}
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		currentAccess = new Access();
		accessDAO = new AccessDAOImpl();

		return "4_ADMtelaLogin?faces-redirect=true";
	}

	public Access getCurrentAccess() {
		return currentAccess;
	}

	public void setCurrentAccess(Access currentAccess) {
		this.currentAccess = currentAccess;
	}
}
