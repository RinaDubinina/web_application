package com.ekaterinadubinina.java.service;

import com.ekaterinadubinina.java.dao.NotesDaoConn;
import com.ekaterinadubinina.java.structure.Notes;

import java.util.List;

public class NotesService {
    private NotesDaoConn notesDaoConn = new NotesDaoConn();

    public Notes getNotes(int id) {
        return notesDaoConn.getNotes(id);
    }

    public List<Notes> getAllNotes() {
        return notesDaoConn.getAllNotes();
    }

    public List<Notes> getAllPersonNotes(int personId) {
        return notesDaoConn.getAllPersonNotes(personId);
    }

    public boolean insertNotes(Notes notes) {
        return notesDaoConn.insertNotes(notes);
    }

    public boolean deleteNotes(int id) {
        return notesDaoConn.deleteNotes(id);
    }
}
