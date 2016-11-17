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
 * Classe entidade do objeto Alergias referente a tabela tb_allergies
 * @author luiz
 *
 */
@Entity (name="dm_allergy")
public class Allergy implements Serializable {
	
	private static final long serialVersionUID = -598624495299201208L;
	private Integer idAllergy;
	private Long cpf;
	private String description;
	
	@GeneratedValue
	@Id
    @Column(name="id_allergy")
	public Integer getIdAllergy() {
		return idAllergy;
	}
	public void setIdAllergy(Integer idAllergy) {
		this.idAllergy = idAllergy;
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
		return "Allergy [idAllergy=" + idAllergy + ", description=" + description + "]";
	}
	

}
