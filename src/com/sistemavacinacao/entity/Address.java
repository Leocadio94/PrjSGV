package com.sistemavacinacao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * Classe entidade do objeto Endereço referente a tabela tb_addresses
 * 
 * @author luiz
 *
 */
@Entity(name = "tb_addresses")
public class Address implements Serializable {

	private static final long serialVersionUID = 925894020376430259L;
	private Integer seqAddress;
	private Person person;
	private String address;
	private Integer number;

	@Id
	@GeneratedValue
	@Column(name = "seq_address")
	public Integer getSeqAddress() {
		return seqAddress;
	}

	public void setSeqAddress(Integer seqAddress) {
		this.seqAddress = seqAddress;
	}

	@Id
	@ManyToOne
	@JoinColumn(name = "cpf")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "number")
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Address [seqAddress=" + seqAddress + ", cpf=" + person.getCpf() + ", address=" + address + ", number="
				+ number + "]";
	}

}
