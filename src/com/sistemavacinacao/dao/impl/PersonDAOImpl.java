package com.sistemavacinacao.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.sistemavacinacao.dao.IPersonDAO;
import com.sistemavacinacao.entity.Address;
import com.sistemavacinacao.entity.Allergy;
import com.sistemavacinacao.entity.DependenceType;
import com.sistemavacinacao.entity.Dependent;
import com.sistemavacinacao.entity.Diseases;
import com.sistemavacinacao.entity.Email;
import com.sistemavacinacao.entity.Person;
import com.sistemavacinacao.entity.Vaccination;
import com.sistemavacinacao.entity.VaccineType;
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
	public void insertObjects(Object object1,  Object object2) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		em.getTransaction().begin();
				
		if (em.contains(object1)){
			em.persist(object1);
		} else{
			em.merge(object1);
		}
		
		em.persist(object2);
		
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
	public List<DependenceType> selectAllDependenceTypes() throws SQLException {
		EntityManager em = JPAUtil.getConnection();
		
		TypedQuery<DependenceType> qry = 
			em.createQuery("select dt from dm_dependence_type as dt", DependenceType.class);
		
		List<DependenceType> dependenceTypes = qry.getResultList();
			
		em.close();
		
		return dependenceTypes;
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
