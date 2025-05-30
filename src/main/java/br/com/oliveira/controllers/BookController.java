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

import br.com.oliveira.models.Book;
import br.com.oliveira.repositories.BookRepository;
import br.com.oliveira.services.BookServices;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookRepository bookRepository;

	@Autowired
	private BookServices service;

    BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Book findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Book create(@RequestBody Book book) {
		return service.create(book);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Book update(@RequestBody Book book) {
		return service.update(book);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id ){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
