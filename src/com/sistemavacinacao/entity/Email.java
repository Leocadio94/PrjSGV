package com.sistemavacinacao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe entidade do objeto Emails referente a tabela tb_emails
 * 
 * @author luiz
 *
 */
@Entity (name="tb_emails")
public class Email implements Serializable {
	
	private static final long serialVersionUID = 8827665063646935820L;
	private Integer seqEmail;
	private Long cpf;
	private String email;
	
	@GeneratedValue
	@Id
	@Column(name = "seq_email")	
	public Integer getSeqEmail() {
		return seqEmail;
	}
	
	public void setSeqEmail(Integer seqEmail) {
		this.seqEmail = seqEmail;
	}
	
	@Id
	@Column(name = "cpf")
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Email [seqEmail=" + seqEmail + ", cpf=" + cpf + ", email=" + email + "]";
	}

}
