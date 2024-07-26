package com.ch.axa.its.mrinformiusbackend.repositories;

import com.ch.axa.its.mrinformiusbackend.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}
