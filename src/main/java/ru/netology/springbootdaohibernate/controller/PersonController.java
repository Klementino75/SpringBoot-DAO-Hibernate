package ru.netology.springbootdaohibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    @Secured({"ROLE_READ"})
    protected List<Person> getPersonsByCity(
            @RequestParam(value = "city", required = false) String city) {
        var result = personService.getPersonsByCity(city);
        result.forEach(System.out::println);
        return result;
    }

    @GetMapping("/by-age") // localhost:8080/persons/by-age?age=30
    @RolesAllowed("ROLE_WRITE")
    protected List<Person> getPersonsByAge(
            @RequestParam(value = "age", required = false) int age) {
        var result = personService.getPersonsByAge(age);
        result.forEach(System.out::println);
        return result;
    }

    @GetMapping("/by-name-surname") // localhost:8080/persons/by-name-surname?name=Ivan&surname=Ivanov
    @PreAuthorize("hasAnyRole('ROLE_WRITE', 'ROLE_DELETE')")
    protected Optional<Person> getPersonByNameAndSurname(
            @RequestParam(value = "name", required = false) String name,
             @RequestParam(value = "surname", required = false) String surname) {
        var result = personService.getPersonByNameAndSurname(name, surname);
        result.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("There is no such Person!"));
        return result;
    }

    @GetMapping("/by-name-surname-username")
    @PostAuthorize("hasAnyRole('ROLE_WRITE')")
    protected String showUserName(
            @RequestParam(value = "username", required = false) String username) {
        return "ShowUserNamePost: " + username;
    }

    @GetMapping("/hello")
    @PreAuthorize("#username == authentication.principal.username")
    protected String hello(String username) {
        return "Hello, " + username + "!";
    }

    @PostMapping
    protected ResponseEntity<String> createPerson(@RequestBody Person person) {
        personService.createPerson(person);
        return ResponseEntity.ok("The user has been created!");
    }

    @PutMapping
    protected ResponseEntity<String> updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
        return ResponseEntity.ok("The user has been updated!");
    }

    @DeleteMapping
    protected ResponseEntity<String> deletePerson(@RequestBody Person person) {
        personService.deletePerson(person);
        return ResponseEntity.ok("The user has been deleted!");
    }
}