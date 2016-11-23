package com.sistemavacinacao.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.sistemavacinacao.dao.IVaccineDAO;
import com.sistemavacinacao.entity.Person;
import com.sistemavacinacao.entity.Vaccination;
import com.sistemavacinacao.entity.Vaccine;
import com.sistemavacinacao.entity.VaccineType;
import com.sistemavacinacao.util.JPAUtil;

/**
 * Classe responsável por implementar a interface IVaccineDAO
 * @author luiz
 *
 */
public class VaccineDAOImpl implements IVaccineDAO{


	@Override
	public void insertVaccine(Vaccine vaccine) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		em.getTransaction().begin();
		
		if (em.contains(vaccine)){
			em.persist(vaccine);
		} else{
			em.merge(vaccine);
		}
		
		em.getTransaction().commit();

		em.close();
	}

	@Override
	public List<Vaccine> selectAllVaccines() throws SQLException {
		EntityManager em = JPAUtil.getConnection();
		
		TypedQuery<Vaccine> qry = 
			em.createQuery("select v from tb_vaccines as v", Vaccine.class);
		
		List<Vaccine> vaccines = qry.getResultList();
			
		em.close();
		
		return vaccines;
	}
	
	@Override
	public List<VaccineType> selectAllVaccineTypes() throws SQLException {
		EntityManager em = JPAUtil.getConnection();
		
		TypedQuery<VaccineType> qry = 
			em.createQuery("select vt from dm_vaccine_type as vt", VaccineType.class);
		
		List<VaccineType> vaccineTypes = qry.getResultList();
			
		em.close();
		
		return vaccineTypes;
	}
	
	@Override
	public List<Vaccine> selectVaccine(Integer idVaccine) throws SQLException {
		EntityManager em = JPAUtil.getConnection();

		TypedQuery<Vaccine> qry = em.createQuery("select v from tb_vaccines as v "
				+ "where v.id_vaccine = :idv "
				+ "order by v.id_vaccine", Vaccine.class);
		qry.setParameter("idv", idVaccine);

		List<Vaccine> vacs = qry.getResultList();

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
