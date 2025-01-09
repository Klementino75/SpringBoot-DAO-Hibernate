package ru.netology.springbootdaohibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.netology.springbootdaohibernate.entity.Person;
import ru.netology.springbootdaohibernate.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersonsByCity(String city) {
//        return personRepository.findByCity(city);
        return personRepository.getPersonByCity(city);
    }
}