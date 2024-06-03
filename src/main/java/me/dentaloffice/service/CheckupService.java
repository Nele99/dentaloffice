package me.dentaloffice.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import me.dentaloffice.model.Checkup;

import java.util.List;

@Dependent
public class CheckupService {

    @Inject
    private EntityManager em;

    @Transactional
    public Checkup createCheckup(Checkup checkup) {
        return em.merge(checkup);
    }

    public Checkup getCheckupById(Integer id) {
        return em.find(Checkup.class, id);
    }

    public List<Checkup> getAllCheckups() {
        TypedQuery<Checkup> query = em.createQuery("SELECT c FROM Checkup c", Checkup.class);
        return query.getResultList();
    }

    @Transactional
    public Checkup updateCheckup(Checkup checkup) {
        return em.merge(checkup);
    }

    @Transactional
    public void deleteCheckup(Integer id) {
        Checkup checkup = em.find(Checkup.class, id);
        if (checkup != null) {
            em.remove(checkup);
        }
    }
}
