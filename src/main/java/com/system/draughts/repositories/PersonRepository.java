package com.system.draughts.repositories;

import com.system.draughts.domain.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
