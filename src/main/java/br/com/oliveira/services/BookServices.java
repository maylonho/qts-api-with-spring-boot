package br.com.oliveira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.oliveira.models.Book;
import br.com.oliveira.repositories.BookRepository;

@Service
public class BookServices {
	
	@Autowired
	BookRepository repository;
	
	public List<Book> findAll(){
		
		return repository.findAll();
	}
	
	public Book findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado o id informado!"));
	}
	
	public Book create(Book book) {
		book.setId(null);
		return repository.save(book);
	}
	
	public Book update(Book book) {
		var entity = repository.findById(book.getId())
				.orElseThrow();
		
		entity.setAuthor(book.getAuthor());
		entity.setTitle(book.getTitle());
		entity.setPages(book.getPages());
		
		return repository.save(book);
	}
	
	public void delete(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado o id informado!"));
		
		repository.delete(entity);
	}


}
