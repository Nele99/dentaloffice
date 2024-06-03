package me.dentaloffice.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.dentaloffice.model.Dentist;
import me.dentaloffice.service.DentistService;

import java.util.List;

@Path("/api/dentists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DentistRest {

    @Inject
    private DentistService dentistService;

    @GET
    public Response getAllDentists() {
        List<Dentist> dentists = dentistService.getAllDentists();
        return Response.ok(dentists).build();
    }

    @GET
    @Path("/{id}")
    public Response getDentistById(@PathParam("id") Integer id) {
        Dentist dentist = dentistService.getDentistById(id);
        if (dentist != null) {
            return Response.ok(dentist).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response createDentist(Dentist dentist) {
        Dentist createdDentist = dentistService.createDentist(dentist);
        return Response.ok(createdDentist).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateDentist(@PathParam("id") Integer id, Dentist dentist) {
        dentist.setId(id);
        Dentist updatedDentist = dentistService.updateDentist(dentist);
        return Response.ok(updatedDentist).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDentist(@PathParam("id") Integer id) {
        dentistService.deleteDentist(id);
        return Response.noContent().build();
    }
}
