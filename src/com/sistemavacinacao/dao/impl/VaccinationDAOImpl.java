package com.sistemavacinacao.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.sistemavacinacao.dao.IVaccinationDAO;
import com.sistemavacinacao.entity.Employee;
import com.sistemavacinacao.entity.Local;
import com.sistemavacinacao.entity.Person;
import com.sistemavacinacao.entity.Vaccination;
import com.sistemavacinacao.entity.Vaccine;
import com.sistemavacinacao.util.JPAUtil;

public class VaccinationDAOImpl implements IVaccinationDAO {

	@Override
	public void insertVaccination(Vaccination vaccination) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		em.getTransaction().begin();

		if (em.contains(vaccination)) {
			em.persist(vaccination);
		} else {
			em.merge(vaccination);
		}

		em.getTransaction().commit();

		em.close();
	}

	@Override
	public List<Vaccination> selectAllVaccinations() throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		TypedQuery<Vaccination> qry = em.createQuery("select va from tb_vaccinations as va", Vaccination.class);

		List<Vaccination> vaccinations = qry.getResultList();

		em.close();

		return vaccinations;
	}

	@Override
	public List<Employee> selectAllEmployees() throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		TypedQuery<Employee> qry = em.createQuery("select e from tb_employees as e", Employee.class);

		List<Employee> employees = qry.getResultList();

		em.close();

		return employees;
	}
	

	
	@Override
	public List<Vaccination> selectAllPendingVaccinesForPerson(Person person) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		TypedQuery<Vaccination> qry = em.createQuery("select va from tb_vaccinations as va "
				+ "where va.person.cpf = :cpf and va.dateVaccination >= current_date "
				+ "order by va.dateVaccination", Vaccination.class); 
		qry.setParameter("cpf", person.getCpf());

		List<Vaccination> vacs = qry.getResultList();

		em.close();

		return vacs;
	}
	
	@Override
	public List<Vaccination> selectAllPreviousVaccinesForPerson(Person person) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		TypedQuery<Vaccination> qry = em.createQuery("select va from tb_vaccinations as va "
				+ "where va.person.cpf = :cpf and va.dateVaccination < current_date "
				+ "order by va.dateVaccination", Vaccination.class); 
		qry.setParameter("cpf", person.getCpf());

		List<Vaccination> vacs = qry.getResultList();

		em.close();

		return vacs;
	}

	@Override
	public void deleteVaccine(Vaccine vaccine) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		em.getTransaction().begin();
		Vaccine v1 = em.getReference(Vaccine.class, vaccine.getIdVaccine());
		em.remove(v1);
		em.getTransaction().commit();

		em.close();
	}

}
