package com.sistemavacinacao.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * Classe entidade do objeto Doenças referentes a tabela tb_diseases
 * @author luiz
 *
 */
@Entity (name="dm_disease")
public class Disease implements Serializable {
	
	private static final long serialVersionUID = -4088554684620809084L;
	private Integer idDisease;
	private String description;
	private Long cpf;
	
	@GeneratedValue
	@Id
    @Column(name="id_disease")
	public Integer getIdDisease() {
		return idDisease;
	}
	public void setIdDisease(Integer idDisease) {
		this.idDisease = idDisease;
	}
	
	@Id
	@Column(name="cpf")
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
    @Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Disease [idDisease=" + idDisease + ", description=" + description + "]";
	}
	
	

}
