package com.godel.PeopleService.service;

import com.godel.PeopleService.Entity.Person;
import com.godel.PeopleService.Repository.PersonRepository;
import com.godel.PeopleService.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository peopleRepository;

    public List<Person> getAllPeople() {
        return peopleRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return peopleRepository.findById(id);
    }

    public Person createPerson(PersonDTO person) {
        Person p = Person.builder()
                .id(person.getId())
                .name(person.getName())
                .email(person.getEmail()).build();
        return peopleRepository.save(p);
    }

    public void deletePerson(Long id) {
        peopleRepository.deleteById(id);
    }
}
