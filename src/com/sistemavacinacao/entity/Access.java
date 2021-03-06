package com.sistemavacinacao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe entidade do objeto Access referente a tabela tb_access
 * @author luiz
 *
 */
@Entity (name="tb_access")
public class Access implements Serializable {
	
	private static final long serialVersionUID = -1493041090973345379L;
	private Person person;
	private String  login;
	private String  password;
	private Boolean isAdmin = false;

	@Id
	@ManyToOne(targetEntity=Person.class)
	@JoinColumn(name = "cpf")	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
    @Column(name="login")
	public String getLogin() {
		return login;
	}
    public void setLogin(String login) {
		this.login = login;
	}

    @Column(name="password")
	public String getPassword() {
		return password;
	}
    public void setPassword(String password) {
		this.password = password;
	}
	
    @Column(name="is_admin", columnDefinition = "boolean default false")
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "Access [login="+login+"]";
	}
	
}
