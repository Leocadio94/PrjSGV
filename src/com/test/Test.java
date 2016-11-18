package com.test;

import java.sql.SQLException;
import java.util.Date;

import com.sistemavacinacao.dao.IPersonDAO;
import com.sistemavacinacao.dao.impl.PersonDAOImpl;
import com.sistemavacinacao.entity.Address;
import com.sistemavacinacao.entity.Person;

public class Test {

	public static void main(String args[]) {
		Person person = new Person();
		person.setCpf(299L);
		person.setDtBirth(new Date());
		person.setHas_tattoo(true);
		person.setName("kpe");
		person.setRg("11233");
		person.setWeight(100);

		Address address1 = new Address();
		Address address2 = new Address();

		address1.setAddress("avvvvvvv");
		address1.setNumber(12);
		address2.setAddress("bbbbbbbbbb");
		address2.setNumber(13);

		address1.setPerson(person);
		address2.setPerson(person);

		IPersonDAO pDao = new PersonDAOImpl();
		try {
			pDao.insertObjects(person, address1);
			pDao.insertObjects(person, address2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
