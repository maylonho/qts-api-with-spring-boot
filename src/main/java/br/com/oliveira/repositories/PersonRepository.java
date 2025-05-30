package br.com.oliveira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oliveira.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{}
