package ru.netology.springbootdaohibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ru.netology.springbootdaohibernate.entity.Contact;
import ru.netology.springbootdaohibernate.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Contact> {

    @Query(value = "SELECT p FROM Person p WHERE LOWER(p.cityOfLiving) = LOWER(:city)")
    List<Person> findAllPersonByCityOfLiving(@Param("city") String city);

    @Query(value = "SELECT p FROM Person p WHERE p.contact.age < :age ORDER BY p.contact.age")
    List<Person> findAllByContact_AgeLessThanOrderByContact_Age(@Param("age") int age);

    @Query(value = "SELECT * FROM Person p WHERE LOWER(p.name) = LOWER(:name) AND LOWER(p.surname) = LOWER(:surname)", nativeQuery = true)
    Optional<Person> findAllByContact_NameAndContact_Surname(String name, String surname);
}