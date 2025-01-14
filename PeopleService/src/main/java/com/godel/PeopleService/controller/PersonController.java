package com.godel.PeopleService.controller;

import com.godel.PeopleService.Entity.Person;
import com.godel.PeopleService.dto.PersonDTO;
import com.godel.PeopleService.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonService peopleService;

    @GetMapping
    public List<Person> getAllPeople() {
        return peopleService.getAllPeople();
    }

    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id) {
        return peopleService.getPersonById(id);
    }

    @PostMapping
    public Person createPerson(@RequestBody PersonDTO people) {
        return peopleService.createPerson(people);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        peopleService.deletePerson(id);
    }
}
