package com.sistemavacinacao.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


/**
 * Classe entidade do objeto Pessoa referente a tabela tb_person
 * @author luiz
 *
 */
@Entity (name="tb_person")
public class Person implements Serializable {
	
	private static final long serialVersionUID = 3999005353646732560L;
	private Long  cpf;
	private String  name;
	private String  rg;
	private Integer  weight; 
	private Boolean  has_tattoo;
	private Date  dtBirth;
	private List<Address> addresses;
	private List<Email> emails;
	private List<Vaccination> vaccinations;
	private List<Dependent> dependents;
	private List<Disease> diseases;
	private List<Allergy> allergies;
	
    @Id
    @Column(name="cpf")
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="rg")
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	@Column(name="weight")
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	@Column(name="has_tattoo")
	public Boolean getHas_tattoo() {
		return has_tattoo;
	}
	public void setHas_tattoo(Boolean has_tattoo) {
		this.has_tattoo = has_tattoo;
	}
	
	@Column(name="dt_birth")
	public Date getDtBirth() {
		return dtBirth;
	}
	public void setDtBirth(Date dtBirth) {
		this.dtBirth = dtBirth;
	}
	
	@OneToMany(targetEntity=Address.class, fetch=FetchType.LAZY)
	@JoinColumn(name="seq_address")
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	@OneToMany(targetEntity=Email.class, fetch=FetchType.LAZY)
	@JoinColumn(name="seq_email")
	public List<Email> getEmails() {
		return emails;
	}
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}
	
	@OneToMany(targetEntity=Vaccination.class, fetch=FetchType.LAZY)
	@JoinColumn(name="id_vaccination")
	public List<Vaccination> getVaccinations() {
		return vaccinations;
	}
	public void setVaccinations(List<Vaccination> vaccinations) {
		this.vaccinations = vaccinations;
	}
	
	@OneToMany(targetEntity=Dependent.class, fetch=FetchType.LAZY)
	@JoinColumn(name="cpf_dependent")
	public List<Dependent> getDependents() {
		return dependents;
	}
	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}
	
	@OneToMany(targetEntity=Disease.class, fetch=FetchType.LAZY)
	@JoinColumn(name="id_disease")
	public List<Disease> getDiseases() {
		return diseases;
	}
	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}
	
	@OneToMany(targetEntity=Allergy.class, fetch=FetchType.LAZY)
	@JoinColumn(name="id_allergy")
	public List<Allergy> getAllergies() {
		return allergies;
	}
	public void setAllergies(List<Allergy> allergies) {
		this.allergies = allergies;
	}
	
	
	@Override
	public String toString() {
		return "Person [cpf=" + cpf + ", name=" + name + ", rg=" + rg + ", weight=" + weight + ", has_tattoo="
				+ has_tattoo + ", dtBirth=" + dtBirth + ", addresses=" + addresses + ", emails=" + emails
				+ ", vaccinations=" + vaccinations + ", dependents=" + dependents + ", diseases=" + diseases + ", allergies="
				+ allergies + "]";
	}

}
