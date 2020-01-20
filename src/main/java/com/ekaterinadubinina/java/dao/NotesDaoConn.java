package com.ekaterinadubinina.java.dao;

import com.ekaterinadubinina.java.connection.ConnectionFactory;
import com.ekaterinadubinina.java.structure.CategoryNotes;
import com.ekaterinadubinina.java.structure.Notes;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NotesDaoConn implements NotesDao {
    private static final String SELECT_NOTES_BY_ID = "SELECT * FROM notes WHERE id=";
    private static final String INSERT_INTO_NOTES = "INSERT INTO notes" +
            " (person_id, headline, body, category, phone_number, created_date) VALUES (?,?,?,?,?,?)";
    private static final String DELETE_FROM_NOTES = "DELETE FROM notes WHERE id=?";
    private static final String SELECT_ALL_FROM_NOTES = "SELECT * FROM notes";
    private static final String SELECT_NOTES_BY_PERSON_ID = "SELECT * FROM notes WHERE person_id = ";

    @Override
    public Notes getNotes(int id) {
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_NOTES_BY_ID + id)) {

            while (resultSet.next()) {
                Notes note = new Notes();
                note.setId(id);
                note.setPersonId(resultSet.getInt("person_id"));
                note.setHeadline(resultSet.getString("headline"));
                note.setBody(resultSet.getString("body"));
                note.setCategoryNotes(CategoryNotes.valueOf(resultSet.getString("category")));
                note.setPhoneNumber(resultSet.getString("phone_number"));
                note.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime());

                return note;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertNotes(Notes notes) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_NOTES)) {
            preparedStatement.setInt(1, notes.getPersonId());
            preparedStatement.setString(2, notes.getHeadline());
            preparedStatement.setString(3, notes.getBody());
            preparedStatement.setString(4, notes.getCategoryNotes().toString());
            preparedStatement.setString(5, notes.getPhoneNumber());
            preparedStatement.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteNotes(int id) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE_FROM_NOTES)) {
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

    @Override
    public List<Notes> getAllNotes() {
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_NOTES)) {

            List<Notes> notesList = new ArrayList();
            while (resultSet.next()) {
                Notes notes = new Notes();
                notes.setId(resultSet.getInt("id"));
                notes.setPersonId(resultSet.getInt("person_id"));
                notes.setHeadline(resultSet.getString("headline"));
                notes.setBody(resultSet.getString("body"));
                notes.setCategoryNotes(CategoryNotes.valueOf(resultSet.getString("category")));
                notes.setPhoneNumber(resultSet.getString("phone_number"));
                notes.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime());
                notesList.add(notes);
            }
            return notesList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Notes> getAllPersonNotes(int personId) {
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_NOTES_BY_PERSON_ID + personId)) {
            List<Notes> notesList = new ArrayList<>();
            while (resultSet.next()) {
                Notes notes = new Notes();
                notes.setPersonId(personId);
                notes.setId(resultSet.getInt("id"));
                notes.setHeadline(resultSet.getString("headline"));
                notes.setBody(resultSet.getString("body"));
                notes.setCategoryNotes(CategoryNotes.valueOf(resultSet.getString("category")));
                notes.setPhoneNumber(resultSet.getString("phone_number"));
                notes.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime());

                notesList.add(notes);
            }
            return notesList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
