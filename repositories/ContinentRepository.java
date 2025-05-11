package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.entities.Continents;

import java.util.List;

public class ContinentRepository {
    private final EntityManager em;

    public ContinentRepository(EntityManager em) {
        this.em = em;
    }

    public void create(Continents continent) {
        em.getTransaction().begin();
        em.persist(continent);
        em.getTransaction().commit();
    }

    public Continents findById(Integer id) {
        return em.find(Continents.class, id);
    }

    public List<Continents> findByName(String name) {
        return em.createNamedQuery("Continents.findByName", Continents.class)
                .setParameter("name", name)
                .getResultList();
    }
}
