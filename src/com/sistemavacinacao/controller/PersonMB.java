package com.sistemavacinacao.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sistemavacinacao.dao.IPersonDAO;
import com.sistemavacinacao.dao.IVaccineDAO;
import com.sistemavacinacao.dao.impl.PersonDAOImpl;
import com.sistemavacinacao.dao.impl.VaccineDAOImpl;
import com.sistemavacinacao.entity.Address;
import com.sistemavacinacao.entity.Allergy;
import com.sistemavacinacao.entity.Dependent;
import com.sistemavacinacao.entity.Disease;
import com.sistemavacinacao.entity.Email;
import com.sistemavacinacao.entity.Person;
import com.sistemavacinacao.entity.Vaccination;
import com.sistemavacinacao.entity.Vaccine;

@ManagedBean
@SessionScoped
public class PersonMB implements Serializable {

	private static final long serialVersionUID = -4909314215002235519L;

	private Person currentPerson;
	private Address currentAddress;
	private Email currentEmail;
	private Vaccination currentVaccination;
	private Dependent currentDependent;
	private Disease currentDisease;
	private Allergy currentAllergy;

	private List<Person> people;
	private List<Address> addresses;
	private List<Email> emails;
	private List<Vaccine> vaccines;
	private List<Vaccination> vaccinations;
	private List<Dependent> dependents;
	private List<Disease> diseases;
	private List<Allergy> allergies;

	private IPersonDAO personDAO;
	private IVaccineDAO vaccineDAO;

	private boolean showForm;

	public PersonMB() {
		showForm = false;
		
		initialize();
		//teste();
		
		personDAO = new PersonDAOImpl();
		vaccineDAO = new VaccineDAOImpl();

		people = new ArrayList<Person>();
		vaccines = new ArrayList<Vaccine>();

		// read();
	}
	
	public void initialize() {
		currentPerson = new Person();
		currentAddress = new Address();
		currentEmail = new Email();
		currentVaccination = new Vaccination();
		currentDependent = new Dependent();
		currentDisease = new Disease();
		currentAllergy = new Allergy();

		addresses = new ArrayList<Address>();
		emails = new ArrayList<Email>();
		vaccinations = new ArrayList<Vaccination>();
		dependents = new ArrayList<Dependent>();
		diseases = new ArrayList<Disease>();
		allergies = new ArrayList<Allergy>();
	}

	public void create() {
		addPerson();

		read();

		initialize();

	}

	public void read() {
		try {
			people = personDAO.selectAllPeople();
			vaccines = vaccineDAO.selectAllVaccines();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Person p) {
		currentPerson = p;
	}

	public void delete(Person p) {
		try {
			personDAO.deletePerson(p);

			read();

			currentPerson = new Person();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addPerson() {
		try {
			personDAO.insertPerson(currentPerson);
			showForm = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addAddress() {
		try {
			currentAddress.setPerson(getCurrentPerson());
			personDAO.insertAddress(getCurrentAddress());
			addresses.add(getCurrentAddress());
			currentAddress = new Address();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addEmail() {

		try {
			currentEmail.setPerson(getCurrentPerson());
			personDAO.insertEmail(getCurrentEmail());
			emails.add(getCurrentEmail());
			currentEmail = new Email();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addVaccination() {
		try {
			currentVaccination.setPerson(getCurrentPerson());
			personDAO.insertVaccination(currentVaccination);
			vaccinations.add(currentVaccination);
			currentVaccination = new Vaccination();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addDependent() {
		try {
			currentDependent.setPerson(getCurrentPerson());
			personDAO.insertDependent(currentDependent);
			dependents.add(currentDependent);
			currentDependent = new Dependent();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addDisease() {
		try {
			currentDisease.setPerson(getCurrentPerson());
			personDAO.insertDisease(currentDisease);
			diseases.add(currentDisease);
			currentDisease = new Disease();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addAllergy() {
		try {
			currentAllergy.setPerson(getCurrentPerson());
			personDAO.insertAllergy(currentAllergy);
			allergies.add(currentAllergy);
			currentAllergy = new Allergy();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
//	public void teste() {
//
//		currentPerson.setCpf(11L);
//		currentPerson.setDtBirth(new Date());
//		currentPerson.setHas_tattoo(true);
//		currentPerson.setName("kpe");
//		currentPerson.setRg("11233");
//		currentPerson.setWeight(100);
//		
//	}
	
	public Person getCurrentPerson() {
		return currentPerson;
	}

	public void setCurrentPerson(Person currentPerson) {
		this.currentPerson = currentPerson;
	}

	public List<Person> getPeople() {
		return people;
	}

	public void setPeople(List<Person> people) {
		this.people = people;
	}

	public Address getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public List<Vaccination> getVaccinations() {
		return vaccinations;
	}

	public void setVaccinations(List<Vaccination> vaccinations) {
		this.vaccinations = vaccinations;
	}

	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}

	public List<Disease> getDiseases() {
		return diseases;
	}

	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}

	public List<Allergy> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<Allergy> allergies) {
		this.allergies = allergies;
	}

	public Email getCurrentEmail() {
		return currentEmail;
	}

	public void setCurrentEmail(Email currentEmail) {
		this.currentEmail = currentEmail;
	}

	public Vaccination getCurrentVaccination() {
		return currentVaccination;
	}

	public void setCurrentVaccination(Vaccination currentVaccination) {
		this.currentVaccination = currentVaccination;
	}

	public Dependent getCurrentDependent() {
		return currentDependent;
	}

	public void setCurrentDependent(Dependent currentDependent) {
		this.currentDependent = currentDependent;
	}

	public Disease getCurrentDisease() {
		return currentDisease;
	}

	public void setCurrentDisease(Disease currentDisease) {
		this.currentDisease = currentDisease;
	}

	public Allergy getCurrentAllergy() {
		return currentAllergy;
	}

	public void setCurrentAllergy(Allergy currentAllergy) {
		this.currentAllergy = currentAllergy;
	}

	public List<Vaccine> getVaccines() {
		return vaccines;
	}

	public void setVaccines(List<Vaccine> vaccines) {
		this.vaccines = vaccines;
	}

	public boolean isShowForm() {
		return showForm;
	}

	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}

}
