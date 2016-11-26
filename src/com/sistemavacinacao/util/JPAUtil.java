package com.sistemavacinacao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("vacinacao");

	public static EntityManager getConnection() {
		EntityManager em = emf.createEntityManager();
		return em;
	}

}