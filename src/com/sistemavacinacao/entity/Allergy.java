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
@Entity (name="tb_allergies")
public class Allergy implements Serializable {
	
	private static final long serialVersionUID = -598624495299201208L;
	private Integer idAllergy;
	private Person person;
	private String name;

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
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
	@Override
	public String toString() {
		return "Allergy [idAllergy=" + idAllergy + ", name=" + name + "]";
	}
	

}
