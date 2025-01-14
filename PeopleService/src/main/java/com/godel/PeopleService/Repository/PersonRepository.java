package com.godel.PeopleService.Repository;

import com.godel.PeopleService.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
