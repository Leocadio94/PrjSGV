package com.sistemavacinacao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe entidade do objeto Employee referente a tabela tb_employees
 * @author luiz
 *
 */
@Entity (name="tb_employees")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = -4054847029987948714L;
	private Long cre;
	private Local local;
	private String nome;
	
	@Id
    @Column(name="cre")
	public Long getCre() {
		return cre;
	}
	public void setCre(Long cre) {
		this.cre = cre;
	}
	
	@Id
	@ManyToOne(targetEntity=Local.class)
	@JoinColumn(name="id_local")
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	
	@Column(name = "nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Employee []";
	}

	
	

}
