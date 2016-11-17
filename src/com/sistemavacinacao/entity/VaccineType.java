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
@Entity (name="dm_vaccine_type")
public class VaccineType implements Serializable {
	
	private static final long serialVersionUID = -1493041090973345379L;
	private Integer  idType;
	private String  name;

	@GeneratedValue
	@Id
	@Column(name = "id_type")	
	public Integer getIdType() {
		return idType;
	}
	public void setIdType(Integer idType) {
		this.idType = idType;
	}
	
    @Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "VaccineType [idType=" + idType +  ", name=" + name + "]";
	}
	
}
