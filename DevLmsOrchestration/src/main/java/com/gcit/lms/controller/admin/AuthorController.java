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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lms.controller.BaseController;
import com.gcit.lms.model.Author;

@RestController
@RequestMapping
public class AuthorController extends BaseController{

	public AuthorController(RestTemplateBuilder restTemplateBuilder) {
		super(restTemplateBuilder);
	}

	@GetMapping(value="/authors",produces= {"application/json","application/xml"})
	public List<Author> getAuthors() {
		ResponseEntity<List> response = template.getForEntity(aport+"/authors", List.class);
		List<Author> authors = response.getBody();
		return authors;
	}
	
	@PostMapping(value="/author",consumes = {"application/json","application/xml"})
	public void addAuthors(@RequestBody Author author) {
		template.postForObject(aport+"/author", author , Author.class);
	}
	
	@PutMapping(value="/author",consumes = {"application/json","application/xml"})
	public void updateAuthors(@RequestBody Author author) {
		template.put(aport+"/author", author);
	}
	
	@DeleteMapping(value="/author/{author-id}")
	public void deleteAuthors(@PathVariable("author-id") Integer authorId) {
		template.delete(aport+"/author/{author-id}", authorId);
	}
}
