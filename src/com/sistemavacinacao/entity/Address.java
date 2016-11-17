package com.sistemavacinacao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe entidade do objeto Endereço referente a tabela tb_addresses
 * @author luiz
 *
 */
@Entity (name="tb_addresses")
public class Address implements Serializable {
	
	private static final long serialVersionUID = 4587897570517268904L;
	private Integer  seqAddress;
	private Long cpf;
	private String  address;
	private Integer  number;
	
	@GeneratedValue
	@Id
    @Column(name="seq_address")
	public Integer getSeqAddress() {
		return seqAddress;
	}
	public void setSeqAddress(Integer seqAddress) {
		this.seqAddress = seqAddress;
	}
	
	@Id
	@Column(name="cpf")
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="number")
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Address [seqAddress=" + seqAddress + ", cpf=" + cpf + ", address=" + address + ", number=" + number
				+ "]";
	}

	
	

}
