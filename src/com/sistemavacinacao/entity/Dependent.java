package com.sistemavacinacao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe entidade do objeto Endereço referente a tabela tb_addresses
 * @author luiz
 *
 */
@Entity (name="tb_dependents")
public class Dependent implements Serializable {
	
	private static final long serialVersionUID = -4054847029987948714L;
	private Integer cpfDependent;
	private Person person;
	
	@Id
    @Column(name="cpf_dependent")
	public Integer getCpfDependent() {
		return cpfDependent;
	}
	public void setCpfDependent(Integer cpfDependent) {
		this.cpfDependent = cpfDependent;
	}
	
	@ManyToOne(targetEntity=Person.class)
	@JoinColumn(name = "cpf")
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public String toString() {
		return "Dependent [cpfDependent=" + cpfDependent + ", cpf=" + person.getCpf() + "]";
	}

	
	

}
