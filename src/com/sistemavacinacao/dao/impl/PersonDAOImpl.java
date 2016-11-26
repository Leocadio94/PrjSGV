package com.sistemavacinacao.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.sistemavacinacao.dao.IPersonDAO;
import com.sistemavacinacao.entity.Access;
import com.sistemavacinacao.entity.Address;
import com.sistemavacinacao.entity.Allergies;
import com.sistemavacinacao.entity.Allergy;
import com.sistemavacinacao.entity.DependenceType;
import com.sistemavacinacao.entity.Dependent;
import com.sistemavacinacao.entity.Disease;
import com.sistemavacinacao.entity.Diseases;
import com.sistemavacinacao.entity.Email;
import com.sistemavacinacao.entity.Person;
import com.sistemavacinacao.entity.Vaccination;
import com.sistemavacinacao.entity.VaccineType;
import com.sistemavacinacao.util.JPAUtil;

/**
 * Classe responsável por implementar a interface IPersonDAO
 * 
 * @author luiz
 *
 */
public class PersonDAOImpl implements IPersonDAO {

	@Override
	public void insertPerson(Person person) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		em.getTransaction().begin();

		if (em.contains(person)) {
			em.persist(person);
		} else {
			em.merge(person);
		}

		em.getTransaction().commit();

		em.close();
	}

	@Override
	public void insertObjects(Object object1, Object object2) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		em.getTransaction().begin();

		if (em.contains(object1)) {
			em.persist(object1);
		} else {
			em.merge(object1);
		}

		em.persist(object2);

		em.getTransaction().commit();

		em.close();
	}

	@Override
	public void insertObjectsMerge(Object object1, Object object2) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		em.getTransaction().begin();

		if (em.contains(object1)) {
			em.persist(object1);
		} else {
			em.merge(object1);
		}
		
		if (em.contains(object2)) {
			em.persist(object2);
		} else {
			em.merge(object2);
		}

		em.getTransaction().commit();

		em.close();
	}
	@Override
	public List<Person> selectAllPeople() throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		TypedQuery<Person> qry = em.createQuery("select p from tb_person as p", Person.class);

		List<Person> people = qry.getResultList();

		em.close();

		return people; // TODO limitar alterar/excluir apenas a não-admins
	}

	@Override
	public List<Disease> selectAllDisease() throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		TypedQuery<Disease> qry = em.createQuery("select d from dm_disease as d", Disease.class);

		List<Disease> disease = qry.getResultList();

		em.close();

		return disease;
	}

	@Override
	public List<Allergy> selectAllAllergy() throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		TypedQuery<Allergy> qry = em.createQuery("select a from dm_allergy as a", Allergy.class);

		List<Allergy> allergy = qry.getResultList();

		em.close();

		return allergy;
	}

	@Override
	public List<DependenceType> selectAllDependenceTypes() throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		TypedQuery<DependenceType> qry = em.createQuery("select dt from dm_dependence_type as dt",
				DependenceType.class);

		List<DependenceType> dependenceTypes = qry.getResultList();

		em.close();

		return dependenceTypes;
	}

	@Override
	public List<Person> selectPerson(Long cpf) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		TypedQuery<Person> qry = em
				.createQuery("select p from tb_person as p " + "where p.cpf = :cpf " + "order by p.cpf", Person.class);
		qry.setParameter("cpf", cpf);

		List<Person> pers = qry.getResultList();

		em.close();

		return pers;
	}

	@Override
	public Access selectAccess(Person person) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		TypedQuery<Access> qry = em.createQuery("select a from tb_access as a where a.person.cpf = :cpf", Access.class);
		qry.setParameter("cpf", person.getCpf());

		Access login = new Access();

		if (!qry.getResultList().isEmpty()) {
			login = (Access) qry.getSingleResult();
		} else {
			login = null;
		}

		em.close();

		return login;
	}

	@Override
	public void deletePerson(Person person) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		em.getTransaction().begin();

		Query qry = em.createQuery("delete from tb_access as a where a.person.cpf = :cpf");
		qry.setParameter("cpf", person.getCpf());
		qry.executeUpdate();
		
		qry = em.createQuery("delete from tb_addresses as ad where ad.person.cpf = :cpf");
		qry.setParameter("cpf", person.getCpf());
		qry.executeUpdate();
		
		qry = em.createQuery("delete from tb_allergies as al where al.person.cpf = :cpf");
		qry.setParameter("cpf", person.getCpf());
		qry.executeUpdate();
		
		qry = em.createQuery("delete from tb_dependents as d where d.person.cpf = :cpf");
		qry.setParameter("cpf", person.getCpf());
		qry.executeUpdate();
		
		qry = em.createQuery("delete from tb_diseases as di where di.person.cpf = :cpf");
		qry.setParameter("cpf", person.getCpf());
		qry.executeUpdate();
		
		qry = em.createQuery("delete from tb_emails as e where e.person.cpf = :cpf");
		qry.setParameter("cpf", person.getCpf());
		qry.executeUpdate();
		
		qry = em.createQuery("delete from tb_phones as p where p.person.cpf = :cpf");
		qry.setParameter("cpf", person.getCpf());
		qry.executeUpdate();
		
		qry = em.createQuery("delete from tb_vaccinations as v where v.person.cpf = :cpf");
		qry.setParameter("cpf", person.getCpf());
		qry.executeUpdate();
		
		Person p1 = em.getReference(Person.class, person.getCpf());
		em.remove(p1);

		em.getTransaction().commit();

		em.close();
	}

}
