package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.Person;

public interface PersonDao {
	public Person savePerson(int eid,Person person);
	public boolean deletePersonByID(int pid);
	public Person getPersonById(int pid);
	public Person updatePersonById(int pid,Person person);
	public List<Person> getAllPerson();
	public List<Person> getPersonByGender(String Gender);
	public List<Person>getPersonByAge(int age);
	public Person getPersonByPhone(long phone);
}