package com.sistemavacinacao.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sistemavacinacao.dao.IPersonDAO;
import com.sistemavacinacao.dao.IVaccinationDAO;
import com.sistemavacinacao.dao.IVaccineDAO;
import com.sistemavacinacao.dao.impl.PersonDAOImpl;
import com.sistemavacinacao.dao.impl.VaccinationDAOImpl;
import com.sistemavacinacao.dao.impl.VaccineDAOImpl;
import com.sistemavacinacao.entity.Access;
import com.sistemavacinacao.entity.Employee;
import com.sistemavacinacao.entity.Local;
import com.sistemavacinacao.entity.Person;
import com.sistemavacinacao.entity.Vaccination;
import com.sistemavacinacao.entity.Vaccine;

@ManagedBean
@SessionScoped
public class VaccinationCardMB implements Serializable {

	private static final long serialVersionUID = -431403359827534323L;

	@ManagedProperty(value = "#{accessMB}")
	private AccessMB accessMB;

	private Access login;
	private Person currentPerson;
	private Vaccination currentVaccination;

	private List<Vaccination> previousVaccinations;
	private List<Vaccination> nextVaccinations;

	private IVaccinationDAO vaccinationDAO;

	public VaccinationCardMB() {
		currentPerson = new Person();
		currentVaccination = new Vaccination();

		previousVaccinations = new ArrayList<Vaccination>();
		nextVaccinations = new ArrayList<Vaccination>();

		vaccinationDAO = new VaccinationDAOImpl();
	}

	@PostConstruct
	public void init() {
		login = accessMB.getCurrentAccess();
		currentPerson = login.getPerson();

		if (currentPerson.getCpf() == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "ERRO"));
		}
		
		readPrevious();
		readNext();
	}

	public void readPrevious() {
		try {
			previousVaccinations = vaccinationDAO.selectAllPreviousVaccinesForPerson(currentPerson);
		} catch (SQLException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na leitura das vacinas anteriores!", "ERRO"));
		}
	}

	public void readNext() {
		try {
			nextVaccinations = vaccinationDAO.selectAllPendingVaccinesForPerson(currentPerson);
		} catch (SQLException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na leitura das próximas vacinas!", "ERRO"));
		}
	}

	public List<Vaccination> getPreviousVaccinations() {
		return previousVaccinations;
	}

	public void setPreviousVaccinations(List<Vaccination> previousVaccinations) {
		this.previousVaccinations = previousVaccinations;
	}

	public List<Vaccination> getNextVaccinations() {
		return nextVaccinations;
	}

	public void setNextVaccinations(List<Vaccination> nextVaccinations) {
		this.nextVaccinations = nextVaccinations;
	}

	public Vaccination getCurrentVaccination() {
		return currentVaccination;
	}

	public void setCurrentVaccination(Vaccination currentVaccination) {
		this.currentVaccination = currentVaccination;
	}

	public AccessMB getAccessMB() {
		return accessMB;
	}

	public void setAccessMB(AccessMB accessMB) {
		this.accessMB = accessMB;
	}

	public Access getLogin() {
		return login;
	}

	public void setLogin(Access login) {
		this.login = login;
	}
}
