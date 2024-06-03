package me.dentaloffice.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.dentaloffice.model.Patient;
import me.dentaloffice.service.PatientService;

import java.util.List;

@Path("/api/patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientRest {

    @Inject
    private PatientService patientService;

    @GET
    public Response getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return Response.ok(patients).build();
    }

    @GET
    @Path("/{id}")
    public Response getPatientById(@PathParam("id") Integer id) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            return Response.ok(patient).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response createPatient(Patient patient) {
        Patient createdPatient = patientService.createPatient(patient);
        return Response.ok(createdPatient).build();
    }

    @PUT
    @Path("/{id}")
    public Response updatePatient(@PathParam("id") Integer id, Patient patient) {
        patient.setId(id);
        Patient updatedPatient = patientService.updatePatient(patient);
        return Response.ok(updatedPatient).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePatient(@PathParam("id") Integer id) {
        patientService.deletePatient(id);
        return Response.noContent().build();
    }
}
