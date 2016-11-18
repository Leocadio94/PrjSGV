package com.sistemavacinacao.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * Classe entidade do objeto Pessoa referente a tabela tb_person
 * 
 * @author luiz
 *
 */
@Entity(name = "tb_person")
public class Person implements Serializable {

	private static final long serialVersionUID = 3999005353646732560L;
	private Long cpf;
	private String name;
	private String rg;
	private Integer weight;
	private Boolean has_tattoo;
	private Date dtBirth;
	
	@Id
	@Column(name = "cpf")
	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "rg")
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Column(name = "weight")
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Column(name = "has_tattoo")
	public Boolean getHas_tattoo() {
		return has_tattoo;
	}

	public void setHas_tattoo(Boolean has_tattoo) {
		this.has_tattoo = has_tattoo;
	}

	@Column(name = "dt_birth")
	public Date getDtBirth() {
		return dtBirth;
	}

	public void setDtBirth(Date dtBirth) {
		this.dtBirth = dtBirth;
	}


	@Override
	public String toString() {
		return "Person [cpf=" + cpf + ", name=" + name + ", rg=" + rg + ", weight=" + weight + ", has_tattoo="
				+ has_tattoo + ", dtBirth=" + dtBirth + "]";
	}

}
