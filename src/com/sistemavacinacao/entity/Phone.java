package com.sistemavacinacao.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe entidade do objeto Telefones referente a tabela tb_phones
 * 
 * @author luiz
 *
 */
@Entity (name="tb_phones")
public class Phone implements Serializable {

	private static final long serialVersionUID = 2923087035730278561L;
	private Person person;
	private Integer seqPhone;
	private Long phoneNumber;
	
	@Id
	@ManyToOne(targetEntity=Person.class)
	@JoinColumn(name="cpf")
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Id
	@GeneratedValue
    @Column(name="seq_phone")
	public Integer getSeqPhone() {
		return seqPhone;
	}
	public void setSeqPhone(Integer seqPhone) {
		this.seqPhone = seqPhone;
	}
	
    @Column(name="phone_number")
	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Phone [cpf=" + person.getCpf() + ", seqPhone=" + seqPhone + ", phoneNumber=" + phoneNumber + "]";
	}

}
