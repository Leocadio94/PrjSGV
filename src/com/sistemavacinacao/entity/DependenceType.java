package com.sistemavacinacao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Classe entidade do objeto VacinaTipo referente a tabela dm_vaccine_type
 * @author luiz
 *
 */
@Entity (name="dm_dependence_type")
public class DependenceType implements Serializable {
	
	private static final long serialVersionUID = -1493041090973345379L;
	private Integer  idType;
	private String  description;

	@GeneratedValue
	@Id
	@Column(name = "id_dependence_type")	
	public Integer getIdType() {
		return idType;
	}
	public void setIdType(Integer idType) {
		this.idType = idType;
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
		return "DescriptionType [idType=" + idType +  ", description=" + description + "]";
	}
	
}
