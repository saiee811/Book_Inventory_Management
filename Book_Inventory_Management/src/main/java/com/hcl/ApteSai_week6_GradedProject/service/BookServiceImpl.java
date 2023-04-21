package com.hcl.ApteSai_week6_GradedProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ApteSai_week6_GradedProject.Exceptions.BookCannotBeDeletedException;
import com.hcl.ApteSai_week6_GradedProject.Exceptions.BookNotFoundException;
import com.hcl.ApteSai_week6_GradedProject.Repo.BookRepo;
import com.hcl.ApteSai_week6_GradedProject.beans.BookPojo;

@Service
public class BookServiceImpl implements BookService
{
	
	@Autowired
	BookRepo book;

	@Override
	public List<BookPojo> getAllBooks() 
	{
		List<BookPojo> booklist = (List<BookPojo>)book.findAll();
		
		return booklist;
	}
	
	

	@Override
	public BookPojo getBook(Integer bId) throws BookNotFoundException 
	{
		Optional<BookPojo> opBook=  book.findById(bId);
		BookPojo book1 =opBook.orElseThrow(()->new BookNotFoundException());
		return book1;

	}
	
	
	

	@Override
	public BookPojo addBook(BookPojo book1) 
	{
		
		return book.save(book1);
	}
	
	
	

	@Override
	public BookPojo updateBook(Integer bId, BookPojo book1) 
	{
		
		BookPojo b = null;
		
		Optional<BookPojo> opBook=  book.findById(bId);

		if(opBook.isPresent()) 
		{
			b=	book.save(book1);
		}
		return b;

	}
	
	
	

	@Override
	public void deleteBook(Integer bId) throws BookCannotBeDeletedException 
	{
		
		Optional<BookPojo> b=null;
		b=book.findById(bId);
		BookPojo book1= b.orElseThrow(()->new BookCannotBeDeletedException("Book with Id "+bId+" is not available"));
		book.delete(book1);

		
		
	}
	
	
	
	
	@Override
	public List<BookPojo> getBookByAuthor(String author) throws BookNotFoundException 
	{
		return book.findByauthor(author);
	}
	
	
	
	
	@Override
	public List<BookPojo> getBookByPrice(Integer price) throws BookNotFoundException 
	{
		
		return book.findByprice(price);

	}
	
	
	@Override
	public  List<BookPojo> getBookBybName(String bName) throws BookNotFoundException 
	{
		return book.findBybName(bName);

	}
	
	
	
	
	@Override
	public List<BookPojo> findAllOrderByPriceAsc() 
	{
		return book.findAllOrderByPriceAsc();
		
	}
	
	
	
	

}
