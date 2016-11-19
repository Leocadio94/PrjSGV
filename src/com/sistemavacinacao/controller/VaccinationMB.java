package com.sistemavacinacao.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sistemavacinacao.dao.IPersonDAO;
import com.sistemavacinacao.dao.IVaccineDAO;
import com.sistemavacinacao.dao.impl.PersonDAOImpl;
import com.sistemavacinacao.dao.impl.VaccineDAOImpl;
import com.sistemavacinacao.entity.Person;
import com.sistemavacinacao.entity.Vaccination;
import com.sistemavacinacao.entity.Vaccine;
import com.sistemavacinacao.entity.VaccineType;

@ManagedBean
@SessionScoped
public class VaccinationMB implements Serializable {

	private static final long serialVersionUID = -4909314215002235519L;
	private Person currentPerson;
	private Vaccination currentVaccination;
	private List<Person> people;
	private List<Vaccine> vaccines;
	private IPersonDAO personDAO;
	private IVaccineDAO vaccineDAO;

	public VaccinationMB() {
		currentVaccination = new Vaccination();
		currentPerson = new Person();
		people = new ArrayList<Person>();
		vaccines = new ArrayList<Vaccine>();
		personDAO = new PersonDAOImpl();
		vaccineDAO = new VaccineDAOImpl();
		read();
	}

	public void create() {
		try {
			currentVaccination.setPerson(currentPerson);
			personDAO.insertObjects(currentPerson, currentVaccination);
			read();
			currentVaccination = new Vaccination();

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Vacinação cadastrada com sucesso!", "SUCESSO"));
		} catch (SQLException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da vacinação!", "ERRO"));
		}

	}

	public void read() {
		try {
			people = personDAO.selectAllPeople();
			vaccines = vaccineDAO.selectAllVaccines();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Person getCurrentPerson() {
		return currentPerson;
	}

	public void setCurrentPerson(Person currentPerson) {
		this.currentPerson = currentPerson;
	}

	public Vaccination getCurrentVaccination() {
		return currentVaccination;
	}

	public void setCurrentVaccination(Vaccination currentVaccination) {
		this.currentVaccination = currentVaccination;
	}

	public List<Person> getPeople() {
		return people;
	}

	public void setPeople(List<Person> people) {
		this.people = people;
	}

	public List<Vaccine> getVaccines() {
		return vaccines;
	}

	public void setVaccines(List<Vaccine> vaccines) {
		this.vaccines = vaccines;
	}

}
