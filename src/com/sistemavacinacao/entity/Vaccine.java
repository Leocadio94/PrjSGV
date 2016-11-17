package com.sistemavacinacao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe entidade do objeto Vacinas referente a tabela tb_vaccines
 * @author luiz
 *
 */
@Entity (name="tb_vaccines")
public class Vaccine implements Serializable {
	
	private static final long serialVersionUID = -1493041090973345379L;
	private Integer  idVaccine;
	private Integer  lot;
	private Date  validate;
	private String  name;
	private VaccineType vaccineType;

	@GeneratedValue
	@Id
	@Column(name = "id_vaccine")	
	public Integer getIdVaccine() {
		return idVaccine;
	}
	public void setIdVaccine(Integer idVaccine) {
		this.idVaccine = idVaccine;
	}
	
    @Column(name="lot")
	public Integer getLot() {
		return lot;
	}
	public void setLot(Integer lot) {
		this.lot = lot;
	}
	
    @Column(name="validate")
	public Date getValidate() {
		return validate;
	}
	public void setValidate(Date validate) {
		this.validate = validate;
	}
	
    @Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne(targetEntity=VaccineType.class)
    @JoinColumn(name="id_type")
	public VaccineType getVaccineType() {
		return vaccineType;
	}
    public void setVaccineType(VaccineType vaccineType) {
		this.vaccineType = vaccineType;
	}
    
	@Override
	public String toString() {
		return "Vaccine [idVaccine=" + idVaccine + ", lot=" + lot + ", validate=" + validate + ", name=" + name
				+ ", idType=" + vaccineType.getIdType() + "]";
	}
	
}
