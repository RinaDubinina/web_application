package com.ekaterinadubinina.java.rest;

import com.ekaterinadubinina.java.service.NotesService;
import com.ekaterinadubinina.java.structure.Notes;
import com.ekaterinadubinina.java.structure.Person;
import com.ekaterinadubinina.java.service.PersonService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

@Path("/persons")
public class PersonController {
    PersonService personService = new PersonService();
    NotesService notesService = new NotesService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons() {
        Set<Person> persons = personService.getAllPerson();
        if (persons.isEmpty()) {
            return Response.status(404).build();
        }
        return Response.status(200).entity(persons).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonID(@PathParam("id") int id) {
        Person personID = personService.getPerson(id);
        if (personID != null) {
            return Response.status(200).entity(personID).build();
        }
        return Response.status(404).build();
    }

    @GET
    @Path("/{id}/notes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersonNotes(@PathParam("id") int personId) {
        List<Notes> notesPerson = notesService.getAllPersonNotes(personId);
        if (notesPerson != null) {
            return Response.status(200).entity(notesPerson).build();
        } else {
            return Response.status(404).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)

    public Response insertPerson(Person person) {
        boolean insertPerson = personService.insertPerson(person);
        if (insertPerson) {
            return Response.status(201).entity("Person inserted").build();
        } else {
            return Response.status(404).build();
        }
    }

    @DELETE
    @Path("/{id}")

    public Response deletePerson(@PathParam("id") int id) {
        boolean delPerson = personService.deletePerson(id);
        if (delPerson) {
            return Response.status(200).entity("Person deleted").build();
        } else {
            return Response.status(404).build();
        }
    }
}
