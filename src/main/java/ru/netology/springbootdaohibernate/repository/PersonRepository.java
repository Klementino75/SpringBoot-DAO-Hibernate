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
    private final EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        final String script = "SELECT p FROM Person p WHERE LOWER(p.cityOfLiving) = LOWER(:city)";
        List<Person> resultList = entityManager.createQuery(script, Person.class)
                .setParameter("city", city)
                .getResultList();
        resultList.forEach(System.out::println);
        return resultList;
//        // или так...
//        return entityManager.createQuery(script, Person.class)
//                .setParameter("city", city)
//                .getResultList();
    }
}