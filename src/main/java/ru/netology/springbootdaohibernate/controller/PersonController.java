package ru.netology.springbootdaohibernate.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.netology.springbootdaohibernate.entity.Person;
import ru.netology.springbootdaohibernate.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private PersonService personService;

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personService.getPersonsByCity(city);
    }
}