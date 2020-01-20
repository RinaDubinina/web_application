package com.ekaterinadubinina.java.dao;

import com.ekaterinadubinina.java.structure.Person;

import java.util.Set;

public interface PersonDao {
    Person getPerson(int id);

    Set<Person> getAllPersons();

    boolean insertPerson(Person person);

    boolean deletePerson(int id);
}
