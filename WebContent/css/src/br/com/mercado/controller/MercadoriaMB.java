package br.com.mercado.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.mercado.model.Mercadoria;
import br.com.mercado.persistence.MercadoriaDAO;
import br.com.mercado.persistence.MercadoriaDAOImpl;

@ManagedBean
@SessionScoped
public class MercadoriaMB implements Serializable {

	private static final long serialVersionUID = -6531605960439837177L;
	private Mercadoria mercadoriaAtual;
	private List<Mercadoria> mercadorias;
	private MercadoriaDAO mercadoriaDAO;
	
	public MercadoriaMB() {
		mercadoriaAtual = new Mercadoria();
		mercadorias = new ArrayList<Mercadoria>();
		mercadoriaDAO = new MercadoriaDAOImpl();
		pesquisar();
	}
	
	public void adicionar() {
		try {
			mercadoriaDAO.adicionar(mercadoriaAtual);
			pesquisar();
			mercadoriaAtual = new Mercadoria();
			
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Mercadoria cadastrada com sucesso!", "SUCESSO"));
		} catch (SQLException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da mercadoria!", "ERRO"));
		}
	}
	
	public void editar(Mercadoria m) {
		mercadoriaAtual	= m;
	}
	
	public void remover(Mercadoria m) {
		try {
			mercadoriaDAO.remover(m);
			pesquisar();
			mercadoriaAtual = new Mercadoria();
			
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Mercadoria removida com sucesso!", "SUCESSO"));
		} catch (SQLException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na remoção da mercadoria!", "ERRO"));
		}
	}
	public void pesquisar() {
		mercadoriaDAO = new MercadoriaDAOImpl();
		
		try {
			mercadorias = mercadoriaDAO.pesquisarTodos();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public Mercadoria getMercadoriaAtual() {
		return mercadoriaAtual;
	}

	public void setMercadoriaAtual(Mercadoria mercadoriaAtual) {
		this.mercadoriaAtual = mercadoriaAtual;
	}

	public List<Mercadoria> getMercadorias() {
		return mercadorias;
	}

	public void setMercadorias(List<Mercadoria> mercadorias) {
		this.mercadorias = mercadorias;
	}
}
