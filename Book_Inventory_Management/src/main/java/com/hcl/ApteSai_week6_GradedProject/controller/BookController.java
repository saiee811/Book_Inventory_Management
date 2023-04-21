package com.hcl.ApteSai_week6_GradedProject.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.hcl.ApteSai_week6_GradedProject.Exceptions.BookCannotBeDeletedException;
import com.hcl.ApteSai_week6_GradedProject.Exceptions.BookNotFoundException;
import com.hcl.ApteSai_week6_GradedProject.beans.BookPojo;
import com.hcl.ApteSai_week6_GradedProject.service.BookService;

@RestController
@RequestMapping("/User")
public class BookController 
{
	
	
	@Autowired
	BookService service;
	
	
	/*@PostMapping(value="/book")
	public ResponseEntity<BookPojo> addBook(@RequestBody BookPojo book1) 
	{
		BookPojo book2 = service.addBook(book1);
		return new ResponseEntity<>(book2,HttpStatus.CREATED);
	}*/
	
	@GetMapping("/books")
	public ResponseEntity<List<BookPojo>> getAllBooks()
	{
		List<BookPojo> bookList= service.getAllBooks();
		return new ResponseEntity<>(bookList,HttpStatus.OK);
	}
	
	
	@GetMapping("/books1")
	public ResponseEntity<List<BookPojo>> getfindAllOrderByPriceAsc()
	{
		List<BookPojo> bookList= service.findAllOrderByPriceAsc();
		return new ResponseEntity<>(bookList,HttpStatus.OK);
	}
	
	
	@GetMapping("/book1/{bId}")
	public ResponseEntity getBook(@PathVariable String bId) throws BookNotFoundException 
	{
		ResponseEntity responseEntity=null;

		BookPojo book1= service.getBook(Integer.parseInt(bId));
		if(book1!=null) 
		{
			responseEntity = new ResponseEntity<>(book1,HttpStatus.OK);


		}
		else 
		{
			responseEntity=  new ResponseEntity<>("Book is not available in inventory",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	
	
	@GetMapping("/book2/{author}")
	public ResponseEntity<List<BookPojo>> getBookByAuthor(@PathVariable String author) throws BookNotFoundException
	{
		List<BookPojo> bookList= service.getBookByAuthor(author);
		return new ResponseEntity<>(bookList,HttpStatus.OK);
	}
	
	
	@GetMapping("/book3/{bName}")
	public ResponseEntity<List<BookPojo>> getBookBybName(@PathVariable String bName) throws BookNotFoundException 
	{

		List<BookPojo> bookList= service.getBookBybName(bName);
		return new ResponseEntity<>(bookList,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/book4/{price}")
	public ResponseEntity<List<BookPojo>> getBookByPrice(@PathVariable Integer price) throws BookNotFoundException 
	{
		
		List<BookPojo> bookList= service.getBookByPrice(price);
		return new ResponseEntity<>(bookList,HttpStatus.OK);
	}




	
	


}
