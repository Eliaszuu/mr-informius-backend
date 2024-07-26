package com.ch.axa.its.mrinformiusbackend.controllers;

import com.ch.axa.its.mrinformiusbackend.domain.Person;
import com.ch.axa.its.mrinformiusbackend.repositories.PersonRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin("*")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody @Valid Person entry) {
        if (personRepository.findById(entry.getId()).isPresent()){
            System.out.println("Person already exists");
        }else {
            System.out.println("Creating person");
        }
        return personRepository.save(entry);
    }

    @GetMapping
    public Iterable<Person> index() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> read(@PathVariable String id) {
        return ResponseEntity.of(personRepository.findById(id));
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable String id, @RequestBody @Valid Person entry) {
        entry.setId(id);
        return personRepository.save(entry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> delete(@PathVariable String id) {
        var entry = personRepository.findById(id);
        if(entry.isPresent()) {
            personRepository.delete(entry.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
