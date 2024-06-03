package me.dentaloffice.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.dentaloffice.model.Checkup;
import me.dentaloffice.service.CheckupService;

import java.util.List;

@Path("/api/checkups")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CheckupRest {

    @Inject
    private CheckupService checkupService;

    @GET
    public Response getAllCheckups() {
        List<Checkup> checkups = checkupService.getAllCheckups();
        return Response.ok(checkups).build();
    }

    @GET
    @Path("/{id}")
    public Response getCheckupById(@PathParam("id") Integer id) {
        Checkup checkup = checkupService.getCheckupById(id);
        if (checkup != null) {
            return Response.ok(checkup).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response createCheckup(Checkup checkup) {
        Checkup createdCheckup = checkupService.createCheckup(checkup);
        return Response.ok(createdCheckup).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateCheckup(@PathParam("id") Integer id, Checkup checkup) {
        checkup.setId(id);
        Checkup updatedCheckup = checkupService.updateCheckup(checkup);
        return Response.ok(updatedCheckup).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCheckup(@PathParam("id") Integer id) {
        checkupService.deleteCheckup(id);
        return Response.noContent().build();
    }
}
