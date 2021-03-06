package com.sistemavacinacao.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
import com.sistemavacinacao.entity.Vaccine;

/**
 * Interface DAO da classe Person
 * @author luiz
 *
 */
public interface IPersonDAO {
	
	/**
	 * Método responsável por inserir pessoas na base de dados
	 * @param pgDB
	 * @param person
	 * @return
	 * @throws SQLException
	 */
	public void insertPerson(Person person) throws SQLException;

	/**
	 * Método responsável por inserir registros na base de dados
	 * @param pgDB
	 * @param person
	 * @return
	 * @throws SQLException
	 */
	public void insertObjects(Object object1, Object object2) throws SQLException;
	

	/**
	 * Método responsável por inserir registros na base de dados
	 * @param pgDB
	 * @param person
	 * @return
	 * @throws SQLException
	 */
	public void insertObjectsMerge(Object object1, Object object2) throws SQLException;
	
	/**
	 * Método responsável por buscar todos os registros de pessoas da base de dados
	 * @param pgDB
	 * @return
	 * @throws SQLException
	 */
	public List<Person> selectAllPeople() throws SQLException;

	/**
	 * Método responsável por buscar todos os registros de acessos da base de dados
	 * @param pgDB
	 * @return
	 * @throws SQLException
	 */
	public List<Access> selectAllAccesses() throws SQLException;
	/**
	 * Método responsável por buscar todos os registros de pessoas da base de dados
	 * @param pgDB
	 * @return
	 * @throws SQLException
	 */
	public List<DependenceType> selectAllDependenceTypes() throws SQLException;

	/**
	 * Método responsável por buscar todos os registros de doenças da base de dados
	 * @param pgDB
	 * @return
	 * @throws SQLException
	 */
	public List<Disease> selectAllDisease() throws SQLException;

	/**
	 * Método responsável por buscar todos os registros de alergias da base de dados
	 * @param pgDB
	 * @return
	 * @throws SQLException
	 */
	public List<Allergy> selectAllAllergy() throws SQLException;
	
	/**
	 * Método responsável por buscar registro de uma pessoa na base de dados
	 * @param pgDB
	 * @param cpf
	 * @return
	 * @throws SQLException
	 */
	public List<Person> selectPerson(Long cpf) throws SQLException;
	
	/**
	 * Método responsável por buscar registro de um "Access" na base de dados
	 * @param pgDB
	 * @param cpf
	 * @return
	 * @throws SQLException
	 */
	public Access selectAccess(Person person) throws SQLException;
	
	/**
	 * Método responsável por deletar registro de uma pessoa na base de dados
	 * @param pgDB
	 * @param person
	 * @return
	 * @throws SQLException
	 */
	public void deletePerson(Person person) throws SQLException;
	
	/**
	 * Método responsável por atualizar registro de pessoa na base de dados
	 * @param pgDB
	 * @param person
	 * @return
	 * @throws SQLException
	 */
	// public void updatePerson(Person person) throws SQLException;
	
	/**
	 * Método responsável por fazer login no sistema
	 * @param pgDB
	 * @param user
	 * @param password
	 * @return
	 * @throws SQLException
	 */
//	public Boolean login(Connection pgDB, String user, String password) throws SQLException;

}
