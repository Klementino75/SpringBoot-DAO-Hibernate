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
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam(value = "city", required = false) String city) {
        return personService.getPersonsByCity(city);
    }
}