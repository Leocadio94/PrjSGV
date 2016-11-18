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
	private Long cpfDependent;
	private Person person;
	private DependenceType dependenceType;
	
	@Id
    @Column(name="cpf_dependent")
	public Long getCpfDependent() {
		return cpfDependent;
	}
	public void setCpfDependent(Long cpfDependent) {
		this.cpfDependent = cpfDependent;
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

	@ManyToOne(targetEntity=DependenceType.class)
	@JoinColumn(name = "id_dependence_type")
	public DependenceType getDependenceType() {
		return dependenceType;
	}
	public void setDependenceType(DependenceType dependenceType) {
		this.dependenceType = dependenceType;
	}
	
	@Override
	public String toString() {
		return "Dependent [cpfDependent=" + cpfDependent + ", cpf=" + person.getCpf() + "]";
	}

	
	

}
