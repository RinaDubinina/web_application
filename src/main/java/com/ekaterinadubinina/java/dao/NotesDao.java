package com.ekaterinadubinina.java.dao;

import com.ekaterinadubinina.java.structure.Notes;

import java.util.List;

public interface NotesDao {
    Notes getNotes(int id);

    boolean insertNotes(Notes notes);

    boolean deleteNotes(int id);

    List<Notes> getAllNotes();

    List<Notes> getAllPersonNotes(int personId);
}
