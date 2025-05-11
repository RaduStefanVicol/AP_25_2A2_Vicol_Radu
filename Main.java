package org.example;

import jakarta.persistence.EntityManager;
import org.example.entities.Continents;
import org.example.entities.Countries;
import org.example.repositories.ContinentRepository;
import org.example.repositories.CountryRepository;
import org.example.util.JPAUtil;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        ContinentRepository continentRepo = new ContinentRepository(em);
        CountryRepository countryRepo = new CountryRepository(em);

        Continents europe = new Continents();
        europe.setName("Europe");
        continentRepo.create(europe);

        Countries romania = new Countries();
        romania.setName("Romania");
        romania.setCode("RO");
        romania.setContinent(europe);
        countryRepo.create(romania);

        Countries germany = new Countries();
        germany.setName("Germany");
        germany.setCode("DE");
        germany.setContinent(europe);
        countryRepo.create(germany);

        System.out.println("Find by ID: " + countryRepo.findById(germany.getId()));
        System.out.println("Find by name 'Ger': " + countryRepo.findByName("Ger"));

        em.close();
        JPAUtil.close();
    }
}
