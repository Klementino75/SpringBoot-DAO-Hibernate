package ru.netology.springbootdaohibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.springbootdaohibernate.entity.Contact;
import ru.netology.springbootdaohibernate.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Contact> {

    List<Person> findAllPersonByCityOfLiving(String cityOfLiving);

    List<Person> findAllByContact_AgeLessThanOrderByContact_Age(int age);

    Optional<Person> findAllByContact_NameAndContact_Surname(String contactName, String surname);
}