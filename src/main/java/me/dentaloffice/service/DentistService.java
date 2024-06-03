package me.dentaloffice.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import me.dentaloffice.model.Dentist;

import java.util.List;

@Dependent
public class DentistService {

    @Inject
    private EntityManager em;

    @Transactional
    public Dentist createDentist(Dentist dentist) {
        return em.merge(dentist);
    }

    public Dentist getDentistById(Integer id) {
        return em.find(Dentist.class, id);
    }

    public List<Dentist> getAllDentists() {
        TypedQuery<Dentist> query = em.createQuery("SELECT d FROM Dentist d", Dentist.class);
        return query.getResultList();
    }

    @Transactional
    public Dentist updateDentist(Dentist dentist) {
        return em.merge(dentist);
    }

    @Transactional
    public void deleteDentist(Integer id) {
        Dentist dentist = em.find(Dentist.class, id);
        if (dentist != null) {
            em.remove(dentist);
        }
    }
}
