package ru.netology.springbootdaohibernate.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import ru.netology.springbootdaohibernate.entity.Person;
import ru.netology.springbootdaohibernate.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private PersonRepository personRepository;

    public List<Person> getPersonsByCity(String city) {
        return personRepository.getPersonByCity(city);
    }
}