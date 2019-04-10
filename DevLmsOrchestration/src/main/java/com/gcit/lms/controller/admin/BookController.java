package com.gcit.lms.controller.admin;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcit.lms.controller.BaseController;
import com.gcit.lms.model.Book;

public class BookController extends BaseController{

	public BookController(RestTemplateBuilder restTemplateBuilder) {
		super(restTemplateBuilder);
		// TODO Auto-generated constructor stub
	}

	@GetMapping(value="/books",produces = {"application/json","application/xml"})
	public List<Book> readAllBooksByName() {
		ResponseEntity<List> response = template.getForEntity(aport+"/books", List.class);
		List<Book> books = response.getBody();
		return books;
	}
	
	@PostMapping(value="/book",consumes = {"application/json","application/xml"})
	public void addBook(@RequestBody Book book) {
		template.postForObject(aport+"/book", book , Book.class);
	}
	
	@PutMapping(value="/book",produces = {"application/json","application/xml"},consumes = {"application/json","application/xml"})
	public Book updateBook(@RequestBody Book book) {
		template.put(aport+"/book", book);
		return book;
	}

	@DeleteMapping(value="/book/{book-id}")
	public void deleteBooks(@PathVariable("book-id") Integer bookId) {
		template.delete(aport+"/book/{book-id}", bookId);
	}
	
	@GetMapping(value="/authors/{author-id}/books",produces = {"application/json","application/xml"})
	public List<Book> readAllBooksByAuthor(@PathVariable("author-id") Integer authorId) {
		ResponseEntity<List> response = template.getForEntity(aport+"/authors/{author-id}/books", List.class, authorId);
		List<Book> books = response.getBody();
		return books;
	}
	
	@GetMapping(value="/genres/{genre-id}/books",produces = {"application/json","application/xml"})
	public List<Book> readAllBooksByGenre(@PathVariable("genre-id") Integer genre_id) {
		ResponseEntity<List> response = template.getForEntity(aport+"/genres/{genre-id}/books", List.class, genre_id);
		List<Book> books = response.getBody();
		return books;
	}
}
