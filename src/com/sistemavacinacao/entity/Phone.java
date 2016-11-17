package com.sistemavacinacao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private Long cpf;
	private Integer seqAddress;
	private Long phoneNumber;
	
	@Id
	@Column(name = "cpf")
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	@Id
    @Column(name="seq_address")
	public Integer getSeqAddress() {
		return seqAddress;
	}

	public void setSeqAddress(Integer seqAddress) {
		this.seqAddress = seqAddress;
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
		return "Phone [cpf=" + cpf + ", seqAddress=" + seqAddress + ", phoneNumber=" + phoneNumber + "]";
	}

}
