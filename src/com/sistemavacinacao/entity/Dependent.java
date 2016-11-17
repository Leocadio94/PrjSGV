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
	private Long cpf;
	
	@Id
    @Column(name="cpf_dependent")
	public Integer getCpfDependent() {
		return cpfDependent;
	}
	public void setCpfDependent(Integer cpfDependent) {
		this.cpfDependent = cpfDependent;
	}
	
	@Column(name = "cpf")
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "Dependent [cpfDependent=" + cpfDependent + ", cpf=" + cpf + "]";
	}

	
	

}
