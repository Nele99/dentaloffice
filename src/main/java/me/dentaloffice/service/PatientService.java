package me.dentaloffice.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import me.dentaloffice.model.Patient;

import java.util.List;

@Dependent
public class PatientService {

    @Inject
    private EntityManager em;

    @Transactional
    public Patient createPatient(Patient patient) {
        return em.merge(patient);
    }

    public Patient getPatientById(Integer id) {
        return em.find(Patient.class, id);
    }

    public List<Patient> getAllPatients() {
        TypedQuery<Patient> query = em.createQuery("SELECT p FROM Patient p", Patient.class);
        return query.getResultList();
    }

    @Transactional
    public Patient updatePatient(Patient patient) {
        return em.merge(patient);
    }

    @Transactional
    public void deletePatient(Integer id) {
        Patient patient = em.find(Patient.class, id);
        if (patient != null) {
            em.remove(patient);
        }
    }
}
