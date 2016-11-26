package com.sistemavacinacao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe entidade do objeto Employee referente a tabela tb_employees
 * @author luiz
 *
 */
@Entity (name="tb_employees")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = -4054847029987948714L;
	private Long cre;
	private Local local;
	private Person person;
	
	@Id
    @Column(name="cre")
	public Long getCre() {
		return cre;
	}
	public void setCre(Long cre) {
		this.cre = cre;
	}
	
	@Id
	@ManyToOne(targetEntity=Local.class)
	@JoinColumn(name="id_local")
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
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
		return "Employee []";
	}

}
