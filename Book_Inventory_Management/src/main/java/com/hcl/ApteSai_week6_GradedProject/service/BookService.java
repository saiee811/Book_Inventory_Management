package com.hcl.ApteSai_week6_GradedProject.service;

import java.util.List;

import com.hcl.ApteSai_week6_GradedProject.Exceptions.BookCannotBeDeletedException;
import com.hcl.ApteSai_week6_GradedProject.Exceptions.BookNotFoundException;
import com.hcl.ApteSai_week6_GradedProject.beans.BookPojo;

public interface BookService 
{
	
	public List<BookPojo> getAllBooks();
	public BookPojo getBook(Integer bId) throws BookNotFoundException;
	public BookPojo addBook(BookPojo book1);
	public BookPojo updateBook(Integer bId,BookPojo book1);
	public void deleteBook(Integer bId) throws BookCannotBeDeletedException;
	
	
	public List<BookPojo> getBookByAuthor(String author) throws BookNotFoundException;
	public List<BookPojo> getBookByPrice(Integer price) throws BookNotFoundException;
	public List<BookPojo> getBookBybName(String bName) throws BookNotFoundException;
	public List<BookPojo> findAllOrderByPriceAsc();
	


}
