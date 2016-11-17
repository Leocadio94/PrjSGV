package br.com.mercado.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="mercadoria")
public class Mercadoria implements Serializable {

	private static final long serialVersionUID = -3379994650138460417L;
	private int id;
	private String tipo;
	private String nome;
	private int quantidade;
	private double preco;
	private String tipoNegocio;
	
	@Id
	@GeneratedValue
	@Column(name="id_mercadoria")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name="tipo_mercadoria")
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name="nome_mercadoria")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="quantidade")
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Column(name="preco")
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Column(name="tipo_negocio")
	public String getTipoNegocio() {
		return tipoNegocio;
	}
	public void setTipoNegocio(String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}
	
	@Override
	public String toString() {
		return getId() + " - " + getNome();
	}
}
