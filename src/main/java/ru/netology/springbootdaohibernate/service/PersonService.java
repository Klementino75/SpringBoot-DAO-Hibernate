package ru.netology.springbootdaohibernate.service;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ru.netology.springbootdaohibernate.entity.Person;
import ru.netology.springbootdaohibernate.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<Person> getPersonsByCity(String city) {
        return personRepository.findAllPersonByCityOfLiving(city);
    }

    public List<Person> getPersonsByAge(int age) {
        return personRepository.findAllByContact_AgeLessThanOrderByContact_Age(age);
    }

    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return personRepository.findAllByContact_NameAndContact_Surname(name, surname);
    }
}