package com.sistemavacinacao.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sistemavacinacao.entity.Access;
import com.sistemavacinacao.entity.Address;
import com.sistemavacinacao.entity.Allergies;
import com.sistemavacinacao.entity.DependenceType;
import com.sistemavacinacao.entity.Dependent;
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
public interface IAccessDAO {
	
	/**
	 * 
	 * @param pgDB
	 * @param person
	 * @return
	 * @throws SQLException
	 */
	public Access login(Access access) throws SQLException;


}
