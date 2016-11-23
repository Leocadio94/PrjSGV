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
import com.sistemavacinacao.entity.Vaccine;
import com.sistemavacinacao.entity.VaccineType;

@ManagedBean
@SessionScoped
public class VaccineMB implements Serializable {

	private static final long serialVersionUID = -273368218065015343L;
	private Vaccine currentVaccine;
	private List<Vaccine> vaccines;
	private List<VaccineType> vaccineTypes;
	private IVaccineDAO vaccineDAO;
	
	public VaccineMB(){
		currentVaccine = new Vaccine();
		vaccineDAO = new VaccineDAOImpl();
		vaccines = new ArrayList<Vaccine>();	
		vaccineTypes = new ArrayList<VaccineType>();
		read();
	}
	public void create(){
		try {
			vaccineDAO.insertVaccine(currentVaccine);
			
			read();
			
			currentVaccine = new Vaccine();
			
			FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Vacina cadastrada com sucesso!",
                                "SUCESSO"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void read() {
		try {
			vaccines = vaccineDAO.selectAllVaccines();
			vaccineTypes = vaccineDAO.selectAllVaccineTypes();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String update(Vaccine v){
		currentVaccine = v;
		return "7_ADMManterVacina?faces-redirect=true";
	}

	public void delete(Vaccine v){
		try {
			vaccineDAO.deleteVaccine(v);

			read();

			currentVaccine = new Vaccine();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Vaccine getCurrentVaccine() {
		return currentVaccine;
	}
	
	public void setCurrentVaccine(Vaccine currentVaccine) {
		this.currentVaccine = currentVaccine;
	}
	
	public List<Vaccine> getVaccines() {
		return vaccines;
	}
	
	public void setVaccines(List<Vaccine> vaccines) {
		this.vaccines = vaccines;
	}
	public List<VaccineType> getVaccineTypes() {
		return vaccineTypes;
	}
	public void setVaccineTypes(List<VaccineType> vaccineTypes) {
		this.vaccineTypes = vaccineTypes;
	}

}
