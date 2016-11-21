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
@Entity (name="dm_local")
public class Local implements Serializable {
	
	private static final long serialVersionUID = -1493041090973345379L;
	private Integer  idLocal;
	private String  name;
	private String  address;

	@GeneratedValue
	@Id
	@Column(name = "id_local")	
	public Integer getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(Integer idLocal) {
		this.idLocal = idLocal;
	}
	
    @Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Local []";
	}
	
}
