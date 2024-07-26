package com.ch.axa.its.mrinformiusbackend;

import com.ch.axa.its.mrinformiusbackend.domain.Person;
import com.ch.axa.its.mrinformiusbackend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Set;

@Component
public class Dataloader implements ApplicationRunner {

    Person[] persons;

    @Autowired
    PersonRepository personRepository;

    public void run(ApplicationArguments args) throws Exception {
        generatePersons();
    }

    public void generatePersons() throws Exception {
        persons = new Person[5];
        for (int i = 0; i < 5; i++) {
            var person = new Person();
            person.setId("45 P3 J5 23 "+ i);
            person.setUserName(i+ " person");
            personRepository.save(person);
            persons[i] = person;
        }
    }

}
