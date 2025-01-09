package ru.netology.springbootdaohibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import ru.netology.springbootdaohibernate.entity.Person;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonByCity(String city) {
        final String script = "SELECT p FROM Person p WHERE LOWER(p.cityOfLiving) = LOWER(:city)";
        return entityManager.createQuery(script, Person.class)
                .setParameter("city", city)
                .getResultList();
    }
}