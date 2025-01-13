package ru.netology.springbootdaohibernate.service;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.netology.springbootdaohibernate.entity.Person;
import ru.netology.springbootdaohibernate.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<Person> getPersonsByCity(String city) {
        return personRepository.getPersonsByCity(city);
    }
}