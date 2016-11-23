package com.sistemavacinacao.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.sistemavacinacao.dao.IAccessDAO;
import com.sistemavacinacao.entity.Access;
import com.sistemavacinacao.util.JPAUtil;

public class AccessDAOImpl implements IAccessDAO {

	@Override
	public Access login(Access access) {
		EntityManager em = JPAUtil.getConnection();

		Query qry = em.createQuery("select a from tb_access as a where a.login = :usuario and a.password = :password");
		qry.setParameter("usuario", access.getLogin());
		qry.setParameter("password", access.getPassword());

		Access login = new Access();

		if (!qry.getResultList().isEmpty()) {
			login = (Access) qry.getSingleResult();
		} else {
			login = null;
		}

		em.close();
		
		return login;
	}

}
