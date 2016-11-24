package com.sistemavacinacao.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Classe entidade do objeto Alergias referente a tabela tb_allergies
 * @author luiz
 *
 */
@Entity (name="tb_allergies")
public class Allergies implements Serializable {
	
	private static final long serialVersionUID = -598624495299201208L;
	private Allergy allergy;
	private Person person;

	@Id
	@ManyToOne(targetEntity=Allergy.class)
	@JoinColumn(name="id_allergy")
	public Allergy getAllergy() {
		return allergy;
	}	
	public void setAllergy(Allergy allergy) {
		this.allergy = allergy;
	}

	@Id
	@ManyToOne(targetEntity=Person.class)
	@JoinColumn(name="cpf")
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
		
	@Override
	public String toString() {
		return "Allergy []";
	}
	

}
