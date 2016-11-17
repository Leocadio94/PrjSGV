package com.sistemavacinacao.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.sistemavacinacao.dao.IPersonDAO;
import com.sistemavacinacao.entity.Address;
import com.sistemavacinacao.entity.Allergy;
import com.sistemavacinacao.entity.Dependent;
import com.sistemavacinacao.entity.Disease;
import com.sistemavacinacao.entity.Email;
import com.sistemavacinacao.entity.Person;
import com.sistemavacinacao.entity.Vaccination;
import com.sistemavacinacao.util.JPAUtil;

/**
 * Classe responsável por implementar a interface IPersonDAO
 * @author luiz
 *
 */
public class PersonDAOImpl implements IPersonDAO {
	
	@Override
	public void insertPerson(Person person) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		em.getTransaction().begin();
		
		if (em.contains(person)){
			em.persist(person);
		} else{
			em.merge(person);
		}
		
		em.getTransaction().commit();

		em.close();
	}
	
	@Override
	public void insertAddress(Address address) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		em.getTransaction().begin();
		
		if (em.contains(address)){
			em.persist(address);
		} else{
			em.merge(address);
		}
		
		em.getTransaction().commit();

		em.close();
	}
	
	@Override
	public void insertEmail(Email email) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		em.getTransaction().begin();
		
		if (em.contains(email)){
			em.persist(email);
		} else{
			em.merge(email);
		}
		
		em.getTransaction().commit();

		em.close();
	}
	
	@Override
	public void insertVaccination(Vaccination vaccination) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		em.getTransaction().begin();
		
		if (em.contains(vaccination)){
			em.persist(vaccination);
		} else{
			em.merge(vaccination);
		}
		
		em.getTransaction().commit();

		em.close();
	}
	
	@Override
	public void insertDependent(Dependent dependent) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		em.getTransaction().begin();
		
		if (em.contains(dependent)){
			em.persist(dependent);
		} else{
			em.merge(dependent);
		}
		
		em.getTransaction().commit();

		em.close();
	}
	
	@Override
	public void insertDisease(Disease disease) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		em.getTransaction().begin();
		
		if (em.contains(disease)){
			em.persist(disease);
		} else{
			em.merge(disease);
		}
		
		em.getTransaction().commit();

		em.close();
	}
	
	@Override
	public void insertAllergy(Allergy allergy) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		em.getTransaction().begin();
		
		if (em.contains(allergy)){
			em.persist(allergy);
		} else {
			em.merge(allergy);
		}
		
		em.getTransaction().commit();

		em.close();
	}

	@Override
	public List<Person> selectAllPeople() throws SQLException {
		EntityManager em = JPAUtil.getConnection();
		
		TypedQuery<Person> qry = 
			em.createQuery("select p from tb_person as p", Person.class);
		
		List<Person> people = qry.getResultList();
			
		em.close();
		
		return people;
	}

	@Override
	public List<Person> selectPerson(Long cpf) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		TypedQuery<Person> qry = em.createQuery("select p from tb_person as p "
				+ "where p.cpf = :cpf "
				+ "order by p.cpf", Person.class);
		qry.setParameter("cpf", cpf);

		List<Person> pers = qry.getResultList();

		em.close();

		return pers;
	}

	@Override
	public void deletePerson(Person person) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		em.getTransaction().begin();
		Person p1 = em.getReference(Person.class, person.getCpf());
		em.remove(p1);
		em.getTransaction().commit();

		em.close();
	}

}
