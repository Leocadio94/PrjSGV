package com.sistemavacinacao.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Classe entidade do objeto Doenças referentes a tabela tb_diseases
 * 
 * @author luiz
 *
 */
@Entity(name = "tb_diseases")
public class Diseases implements Serializable {

	private static final long serialVersionUID = -4088554684620809084L;
	private Integer idDisease;
	private Person person;
	private String name;

	@GeneratedValue
	@Id
	@Column(name = "id_disease")
	public Integer getIdDisease() {
		return idDisease;
	}

	public void setIdDisease(Integer idDisease) {
		this.idDisease = idDisease;
	}

	@Id
	@ManyToOne(targetEntity = Person.class)
	@JoinColumn(name = "cpf")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Disease [idDisease=" + idDisease + "]";
	}

}
