package com.sistemavacinacao.dao;

import com.sistemavacinacao.entity.Access;

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
	public Access login(Access access);


}
