package com.ekaterinadubinina.java.dao;

import com.ekaterinadubinina.java.structure.CategoryPerson;
import com.ekaterinadubinina.java.structure.Person;
import com.ekaterinadubinina.java.connection.ConnectionFactory;

import java.sql.*;
import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;

public class PersonDaoConn implements PersonDao {

    private static final String SELECT_PERSON_BY_ID = "SELECT * FROM person WHERE id=";
    private static final String SELECT_ALL_FROM_PERSON = "SELECT * FROM person ";
    private static final String INSERT_INTO_PERSON = "INSERT INTO person" +
            " (first_name, last_name, email, category) VALUES (?,?,?,?)";
    private static final String DELETE_FROM_PERSON = "DELETE FROM person WHERE id=?";

    @Override
    public Person getPerson(int id) {
        try (Connection connection = ConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_PERSON_BY_ID + id)) {
            while (rs.next()) {
                Person person = new Person();
                person.setId(id);
                person.setFirstName(rs.getString("first_name"));
                person.setLastName(rs.getString("last_name"));
                person.setEmail(rs.getString("email"));
                person.setCategoryPerson(CategoryPerson.valueOf(rs.getString("category")));
                return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<Person> getAllPersons() {
        try (Connection connection = ConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_FROM_PERSON)) {
            Set persons = new HashSet();
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setFirstName(rs.getString("first_name"));
                person.setLastName(rs.getString("last_name"));
                person.setEmail(rs.getString("email"));
                person.setCategoryPerson(CategoryPerson.valueOf(rs.getString("category")));
                persons.add(person);
            }
            return persons;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertPerson(Person person) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_INTO_PERSON)) {
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setString(3, person.getEmail());
            ps.setString(4, person.getCategoryPerson().toString());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletePerson(int id) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE_FROM_PERSON)) {
            prepareStatement.setInt(1, id);
            int i = prepareStatement.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
