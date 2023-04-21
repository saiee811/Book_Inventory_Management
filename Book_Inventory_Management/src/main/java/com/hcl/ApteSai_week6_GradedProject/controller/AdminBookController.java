package com.hcl.ApteSai_week6_GradedProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ApteSai_week6_GradedProject.Exceptions.BookCannotBeDeletedException;
import com.hcl.ApteSai_week6_GradedProject.beans.BookPojo;
import com.hcl.ApteSai_week6_GradedProject.service.BookService;

@RestController
@RequestMapping("/Admin")
public class AdminBookController 
{
	@Autowired
	BookService service;
	
	
	@PostMapping(value="/book")
	public ResponseEntity<BookPojo> addBook(@RequestBody BookPojo book1) 
	{
		BookPojo book2 = service.addBook(book1);
		return new ResponseEntity<>(book2,HttpStatus.CREATED);
	}
	
	@PutMapping("/book/{bId}")
	public BookPojo updateBook(@PathVariable String bId,@RequestBody BookPojo book1)
	{
		return service.updateBook(Integer.parseInt(bId), book1);
	}
	
	
	@DeleteMapping("/book/{bId}")
	public ResponseEntity<String> deleteBook(@PathVariable String bId) throws BookCannotBeDeletedException 
	{
		service.deleteBook(Integer.parseInt(bId));
		return new ResponseEntity<>("Book has been deleted successfully",HttpStatus.OK);
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<BookPojo>> getAllBooks()
	{
		List<BookPojo> bookList= service.getAllBooks();
		return new ResponseEntity<>(bookList,HttpStatus.OK);
	}
	
	
	

}
