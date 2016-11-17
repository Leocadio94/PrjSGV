package br.com.mercado.persistence;

import java.sql.SQLException;
import java.util.List;

import br.com.mercado.model.Mercadoria;

public interface MercadoriaDAO {
	
	public void adicionar (Mercadoria m) throws SQLException;
	public void remover (Mercadoria m) throws SQLException;
	public List<Mercadoria> pesquisarTodos() throws SQLException;
	
}
