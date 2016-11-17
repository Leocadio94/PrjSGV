package com.sistemavacinacao.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sistemavacinacao.entity.Person;
import com.sistemavacinacao.entity.Vaccination;
import com.sistemavacinacao.entity.Vaccine;
import com.sistemavacinacao.entity.VaccineType;

/**
 * Interface DAO da classe Vacina
 * 
 * @author luiz
 *
 */
public interface IVaccineDAO {
	/**
	 *
	 * @param pgDB
	 * @param person
	 * @return
	 * @throws SQLException
	 */
	public void insertVaccine(Vaccine vaccine) throws SQLException;

	/**
	 * 
	 * @param pgDB
	 * @return
	 * @throws SQLException
	 */
	public List<Vaccine> selectAllVaccines() throws SQLException;

	/**
	 * 
	 * @param pgDB
	 * @return
	 * @throws SQLException
	 */
	public List<VaccineType> selectAllVaccineTypes() throws SQLException;

	/**
	 * 
	 * @param pgDB
	 * @param cpf
	 * @return
	 * @throws SQLException
	 */

	/**
	 * Método que busca vacinas pendentes para pessoa na base de dados
	 * 
	 * @param pgDB
	 * @param person
	 * @return
	 * @throws SQLException
	 */
	public List<Vaccination> selectAllPendingVaccinesForPerson(Person person) throws SQLException;

	/**
	 * Método que busca as vacinas anteriores de uma pessoa na base de dados
	 * 
	 * @param pgDB
	 * @param person
	 * @return
	 * @throws SQLException
	 */
	public List<Vaccination> selectAllPreviousVaccinesForPerson(Person person) throws SQLException;

	/**
	 * 
	 * @param cpf
	 * @return
	 * @throws SQLException
	 */
	public List<Vaccine> selectVaccine(Integer idVaccine) throws SQLException;

	/**
	 * 
	 * @param pgDB
	 * @param person
	 * @return
	 * @throws SQLException
	 */
	public void deleteVaccine(Vaccine vaccine) throws SQLException;

}
