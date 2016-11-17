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
 * Classe entidade do objeto Alergias referente a tabela tb_allergies
 * @author luiz
 *
 */
@Entity (name="dm_allergy")
public class Allergy implements Serializable {
	
	private static final long serialVersionUID = -598624495299201208L;
	private Integer idAllergy;
	private Person person;
	private String description;

	@GeneratedValue
	@Id
    @Column(name="id_allergy")
	public Integer getIdAllergy() {
		return idAllergy;
	}
	public void setIdAllergy(Integer idAllergy) {
		this.idAllergy = idAllergy;
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
	
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
		
	@Override
	public String toString() {
		return "Allergy [idAllergy=" + idAllergy + ", description=" + description + "]";
	}
	

}
