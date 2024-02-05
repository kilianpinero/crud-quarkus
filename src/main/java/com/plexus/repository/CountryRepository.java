package com.plexus.repository;

import com.plexus.domain.Country;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


import java.util.List;


@ApplicationScoped
public class CountryRepository  {
    @Inject
    EntityManager entityManager;

    @Transactional
    public List<Country> findAll(){
        return entityManager.createQuery("select c from Country c").getResultList();
    }

    @Transactional
    public void add(Country country){
        entityManager.persist(entityManager.contains(country) ? country : entityManager.merge(country));
    }

    @Transactional
    public void delete(Country country){
        entityManager.remove(entityManager.contains(country) ? country : entityManager.merge(country));
    }

    @Transactional
    public Country findCountry(Long id){
        return entityManager.find(Country.class, id);
    }

    @Transactional
    public void updateCountry(Country country){
        entityManager.merge(country);
    }
}


