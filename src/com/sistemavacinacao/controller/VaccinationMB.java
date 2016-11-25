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
public class VaccinationMB implements Serializable {

	private static final long serialVersionUID = -7454473737374646395L;

	private Vaccination currentVaccination;
	
	private List<Person> people;
	private List<Vaccine> vaccines;
	private List<Employee> employees;
	
	private IPersonDAO personDAO;
	private IVaccineDAO vaccineDAO;
	private IVaccinationDAO vaccinationDAO;

	public VaccinationMB() {
		currentVaccination = new Vaccination();
		
		people = new ArrayList<Person>();
		vaccines = new ArrayList<Vaccine>();
		employees = new ArrayList<Employee>();
		
		personDAO = new PersonDAOImpl();
		vaccineDAO = new VaccineDAOImpl();
		vaccinationDAO = new VaccinationDAOImpl();
		
		read();
	}

	public void create() {
		try {
			personDAO.insertObjects(currentVaccination.getPerson(), currentVaccination);
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
			employees = vaccinationDAO.selectAllEmployees();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public IVaccinationDAO getVaccinationDAO() {
		return vaccinationDAO;
	}

	public void setVaccinationDAO(IVaccinationDAO vaccinationDAO) {
		this.vaccinationDAO = vaccinationDAO;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
