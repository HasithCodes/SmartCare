package com.example.smartcare.service.impl;

import com.example.smartcare.entity.Person;
import com.example.smartcare.repository.PersonRepository;
import com.example.smartcare.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) { return personRepository.save(person); }

    @Override
    public List<Person> getAllPersons() { return personRepository.findAll(); }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
    }

    @Override
    public Person updatePerson(Long id, Person updatedPerson) {
        Person existingPerson = getPersonById(id);
        existingPerson.setName(updatedPerson.getName());
        existingPerson.setGender(updatedPerson.getGender());
        existingPerson.setAddress(updatedPerson.getAddress());
        existingPerson.setPhone(updatedPerson.getPhone());
        existingPerson.setRole(updatedPerson.getRole());
        return personRepository.save(existingPerson);
    }

    @Override
    public void deletePerson(Long id) { personRepository.delete(getPersonById(id)); }
}