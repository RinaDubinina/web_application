package com.ekaterinadubinina.java.rest;

import com.ekaterinadubinina.java.service.NotesService;
import com.ekaterinadubinina.java.structure.Notes;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/notes")
public class NotesController {
    NotesService notesService = new NotesService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllNotes() {
        List<Notes> notesAll = notesService.getAllNotes();
        if (notesAll.isEmpty()) {
            return Response.status(404).build();
        }
        return Response.status(200).entity(notesAll).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotes(@PathParam("id") int id) {
        Notes notes = notesService.getNotes(id);
        if (notes != null) {
            return Response.status(200).entity(notes).build();
        }
        return Response.status(404).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertNotes(Notes notes) {
        boolean insertNotes = notesService.insertNotes(notes);
        if (insertNotes) {
            return Response.status(201).entity("Note inserted").build();
        } else {
            return Response.status(404).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteNotes(@PathParam("id") int id) {
        boolean delNotes = notesService.deleteNotes(id);
        if (delNotes) {
            return Response.status(200).entity("Note deleted").build();
        } else {
            return Response.status(404).build();
        }
    }
}

