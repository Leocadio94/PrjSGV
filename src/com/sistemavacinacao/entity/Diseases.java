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
	private Disease disease;
	private Person person;

	@Id
	@ManyToOne(targetEntity = Disease.class)
	@JoinColumn(name = "id_disease")
	public Disease getDisease() {
		return disease;
	}
	public void setDisease(Disease disease) {
		this.disease = disease;
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

	@Override
	public String toString() {
		return "Diseases []";
	}

}
