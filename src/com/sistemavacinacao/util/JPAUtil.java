package com.sistemavacinacao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	public static EntityManager getConnection(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vacinacao");
		EntityManager em = emf.createEntityManager();
		return em;
	}
	
}