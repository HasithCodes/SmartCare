package com.example.smartcare.service;

import com.example.smartcare.entity.Person;
import java.util.List;

public interface PersonService {
    Person createPerson(Person person);
    List<Person> getAllPersons();
    Person getPersonById(Long id);
    Person updatePerson(Long id, Person person);
    void deletePerson(Long id);
}