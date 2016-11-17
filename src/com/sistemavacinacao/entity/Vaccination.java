package com.sistemavacinacao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe entidade do objeto Vaccinations referente a tabela tb_vaccinations
 * @author luiz
 *
 */
@Entity (name="tb_vaccinations")
public class Vaccination implements Serializable {
	
	private static final long serialVersionUID = -1493041090973345379L;
	private Integer idVaccination;
	private Person person;
	private Vaccine vaccine;
	private Date dateVaccination;
	private Integer dose;

	@GeneratedValue
	@Id
	@Column(name="id_vaccination")
	public Integer getIdVaccination() {
		return idVaccination;
	}
	public void setIdVaccination(Integer idVaccination) {
		this.idVaccination = idVaccination;
	}
	
	@Id
	@ManyToOne(targetEntity=Person.class)
	@JoinColumn(name = "cpf")
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Id
	@ManyToOne(targetEntity=Vaccine.class)
    @JoinColumn(name="id_vaccine")	
	public Vaccine getVaccine() {
		return vaccine;
	}
	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}
	
	@Column(name="date_vaccination")
	public Date getDateVaccination() {
		return dateVaccination;
	}
	public void setDateVaccination(Date dateVaccination) {
		this.dateVaccination = dateVaccination;
	}
	
	@Column(name="dose")
	public Integer getDose() {
		return dose;
	}
	public void setDose(Integer dose) {
		this.dose = dose;
	}
	
	@Override
	public String toString() {
		return "Vaccination []";
	}
	
}
