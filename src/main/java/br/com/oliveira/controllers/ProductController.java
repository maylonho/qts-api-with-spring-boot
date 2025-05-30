package br.com.oliveira.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oliveira.models.Products;
import br.com.oliveira.repositories.ProductRepository;
import br.com.oliveira.services.ProductServices;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productsRepository;

	@Autowired
	private ProductServices service;

    ProductController(ProductRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Products> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Products findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Products create(@RequestBody Products products) {
		return service.create(products);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Products update(@RequestBody Products products) {
		return service.update(products);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id ){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
