package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.entities.Countries;

import java.util.List;

public class CountryRepository {
    private final EntityManager em;

    public CountryRepository(EntityManager em) {
        this.em = em;
    }

    public void create(Countries country) {
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
    }

    public Countries findById(Integer id) {
        return em.find(Countries.class, id);
    }

    public List<Countries> findByName(String name) {
        return em.createNamedQuery("Countries.findByName", Countries.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }
}
