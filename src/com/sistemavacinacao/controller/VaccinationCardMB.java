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
import com.sistemavacinacao.dao.IVaccinationDAO;
import com.sistemavacinacao.dao.IVaccineDAO;
import com.sistemavacinacao.dao.impl.PersonDAOImpl;
import com.sistemavacinacao.dao.impl.VaccinationDAOImpl;
import com.sistemavacinacao.dao.impl.VaccineDAOImpl;
import com.sistemavacinacao.entity.Employee;
import com.sistemavacinacao.entity.Local;
import com.sistemavacinacao.entity.Person;
import com.sistemavacinacao.entity.Vaccination;
import com.sistemavacinacao.entity.Vaccine;

@ManagedBean
@SessionScoped
public class VaccinationCardMB implements Serializable {

	private Person currentPerson;
	private Vaccination currentVaccination;

	private List<Vaccination> previousVaccinations;
	private List<Vaccination> nextVaccinations;

	private IPersonDAO personDAO;
	private IVaccinationDAO vaccinationDAO;

	public VaccinationCardMB() {
		currentPerson = new Person();
		setCurrentVaccination(new Vaccination());

		previousVaccinations = new ArrayList<Vaccination>();
		nextVaccinations = new ArrayList<Vaccination>();

		personDAO = new PersonDAOImpl();
		vaccinationDAO = new VaccinationDAOImpl();

		readPerson();
		readPrevious();
		readNext();
	}

	public void readPerson() { // TODO test - mudar pro usuário logado
		try {
			List<Person> people = personDAO.selectAllPeople();
			currentPerson = people.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void readPrevious() {
		try {
			previousVaccinations = vaccinationDAO.selectAllPreviousVaccinesForPerson(currentPerson);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void readNext() {
		try {
			nextVaccinations = vaccinationDAO.selectAllPendingVaccinesForPerson(currentPerson);
		} catch (SQLException e) {
			e.printStackTrace();
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

}
