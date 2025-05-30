package br.com.oliveira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oliveira.models.Products;

public interface ProductRepository extends JpaRepository<Products, Long>{}
