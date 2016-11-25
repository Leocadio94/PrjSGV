package com.sistemavacinacao.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.sistemavacinacao.dao.IVaccinationDAO;
import com.sistemavacinacao.dao.impl.VaccinationDAOImpl;
import com.sistemavacinacao.entity.Access;
import com.sistemavacinacao.entity.Person;
import com.sistemavacinacao.entity.Vaccination;

@ManagedBean
@SessionScoped
public class VaccinationCardMB implements Serializable {

	private static final long serialVersionUID = -431403359827534323L;

	@ManagedProperty(value = "#{accessMB}")
	private AccessMB accessMB;

	private Access login;
	private Person currentPerson;
	private Vaccination currentVaccination;
	private Date currentDate;

	private List<Vaccination> previousVaccinations;
	private List<Vaccination> nextVaccinations;

	private IVaccinationDAO vaccinationDAO;

	public VaccinationCardMB() {
		currentPerson = new Person();
		currentVaccination = new Vaccination();
		currentDate = new Date();

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

	public void onDateSelect(SelectEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Data selecionada: " + format.format(event.getObject()), "INFO"));
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

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
}
