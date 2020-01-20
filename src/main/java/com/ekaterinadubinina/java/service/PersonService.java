package com.ekaterinadubinina.java.service;

import com.ekaterinadubinina.java.dao.PersonDaoConn;
import com.ekaterinadubinina.java.structure.Person;

import java.util.Set;

public class PersonService {

    private PersonDaoConn personDaoConn = new PersonDaoConn();

    public Person getPerson(int id) {

        return personDaoConn.getPerson(id);
    }

    public Set<Person> getAllPerson() {

        return personDaoConn.getAllPersons();
    }

    public boolean insertPerson(Person person) {

        return personDaoConn.insertPerson(person);
    }

    public boolean deletePerson(int id) {

        return personDaoConn.deletePerson(id);
    }
}
