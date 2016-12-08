package com.sistemavacinacao.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
	private String[] currentDates;

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
		fillDates();
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

	public void fillDates() {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		List<String> dateList = new ArrayList<String> ();
		
		for (Vaccination v : nextVaccinations) {
			dateList.add(format.format(v.getDateVaccination()));
		}
		
		currentDates = new String[dateList.size()];
		currentDates = dateList.toArray(currentDates);
	}
	
	public static String toJavascriptArray(String[] arr){
	    StringBuffer sb = new StringBuffer();
	    sb.append("[");
	    for(int i=0; i<arr.length; i++){
	        sb.append("\"").append(arr[i]).append("\"");
	        if(i+1 < arr.length){
	            sb.append(",");
	        }
	    }
	    sb.append("]");
	    return sb.toString();
	}
	
	public String getFormattedDate() {
		String retorno = "Não há vacinas marcadas para essa data.";
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		for (Vaccination v : nextVaccinations) {
			if (currentDate.equals(v.getDateVaccination())) {
				retorno = "Há uma vacina marcada para a data " + format.format(currentDate) + ".";
			}
		}

		return retorno;
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

	public String getCurrentDates() {
		return Arrays.toString(currentDates);
	}

	public void setCurrentDates(String[] currentDates) {
		this.currentDates = currentDates;
	}
}
