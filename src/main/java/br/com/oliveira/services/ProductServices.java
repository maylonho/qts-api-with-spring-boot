package br.com.oliveira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.oliveira.models.Products;
import br.com.oliveira.repositories.ProductRepository;

@Service
public class ProductServices {
	
	@Autowired
	ProductRepository repository;
	
	public List<Products> findAll(){
		
		return repository.findAll();
	}
	
	public Products findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado o id informado!"));
	}
	
	public Products create(Products products) {
		products.setId(null);
		return repository.save(products);
	}
	
	public Products update(Products products) {
		var entity = repository.findById(products.getId())
				.orElseThrow();
		
		entity.setName(products.getName());
		entity.setQtd(products.getQtd());
		
		return repository.save(products);
	}
	
	public void delete(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado o id informado!"));
		
		repository.delete(entity);
	}


}
