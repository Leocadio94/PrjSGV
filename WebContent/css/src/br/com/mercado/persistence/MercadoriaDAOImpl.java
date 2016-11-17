package br.com.mercado.persistence;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.mercado.model.Mercadoria;
import br.com.mercado.util.JPAUtil;

public class MercadoriaDAOImpl implements MercadoriaDAO {

	@Override
	public void adicionar(Mercadoria m) throws SQLException {
		EntityManager em = JPAUtil.getConnection();
		
		em.getTransaction().begin();
		
		if (em.contains(m)) {
			em.persist(m);
		} else {
			em.merge(m);
		}		
		
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	public void remover(Mercadoria m) throws SQLException {
		EntityManager em = JPAUtil.getConnection();
		
		em.getTransaction().begin();
		
		Mercadoria m1 = em.getReference(Mercadoria.class, m.getId());
		em.remove(m1);
		
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	public List<Mercadoria> pesquisarTodos() throws SQLException {
		EntityManager em = JPAUtil.getConnection();
		
		em.getTransaction().begin();
		
		TypedQuery<Mercadoria> qry = em.createQuery("select m from mercadoria as m", Mercadoria.class);

		List<Mercadoria> mercadorias = qry.getResultList();
		
		em.close();
		
		return mercadorias;
	}

}
