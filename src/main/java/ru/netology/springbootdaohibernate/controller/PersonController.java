package ru.netology.springbootdaohibernate.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.netology.springbootdaohibernate.entity.Person;
import ru.netology.springbootdaohibernate.service.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    @GetMapping("/by-city") // localhost:8080/persons/by-city?city=MOSCOW
    public List<Person> getPersonsByCity(
            @RequestParam(value = "city", required = false) String city) {
        var result = personService.getPersonsByCity(city);
        result.forEach(System.out::println);
        return result;
    }

    @GetMapping("/by-age") // localhost:8080/persons/by-age?age=30
    protected List<Person> getPersonsByAge(
            @RequestParam(value = "age", required = false) int age) {
        var result = personService.getPersonsByAge(age);
        result.forEach(System.out::println);
        return result;
    }

    @GetMapping("/by-name-surname") // localhost:8080/persons/by-name-surname?name=Ivan&surname=Ivanov
    protected Optional<Person> getPersonByNameAndSurname(
            @RequestParam(value = "name", required = false) String name,
             @RequestParam(value = "surname", required = false) String surname) {
        var result = personService.getPersonByNameAndSurname(name, surname);
        result.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("There is no such Person!"));
        return result;
    }
}