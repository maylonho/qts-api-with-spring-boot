package br.com.oliveira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oliveira.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{}
