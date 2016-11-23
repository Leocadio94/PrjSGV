package com.sistemavacinacao.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sistemavacinacao.entity.Employee;
import com.sistemavacinacao.entity.Local;
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
public interface IVaccinationDAO {
	/**
	 *
	 * @param pgDB
	 * @param person
	 * @return
	 * @throws SQLException
	 */
	public void insertVaccination(Vaccination vaccination) throws SQLException;

	/**
	 * 
	 * @param pgDB
	 * @return
	 * @throws SQLException
	 */
	public List<Vaccination> selectAllVaccinations() throws SQLException;

	/**
	 * 
	 * @param pgDB
	 * @return
	 * @throws SQLException
	 */
	public List<Employee> selectAllEmployees() throws SQLException;

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
	 * @param pgDB
	 * @param person
	 * @return
	 * @throws SQLException
	 */
	public void deleteVaccine(Vaccine vaccine) throws SQLException;

}
