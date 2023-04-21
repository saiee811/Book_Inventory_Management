package com.hcl.ApteSai_week6_GradedProject.Repo;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hcl.ApteSai_week6_GradedProject.beans.BookPojo;
import com.hcl.ApteSai_week6_GradedProject.beans.UserBean;

public interface BookRepo extends CrudRepository<BookPojo, Integer> 
{

	@Query("select b from BookPojo b where b.author= ?1 ")
	List<BookPojo> findByauthor(String author);

	@Query("select b from BookPojo b where b.price= ?1 ")
	List<BookPojo> findByprice(Integer price);

	@Query("select b from BookPojo b where b.bName= ?1 ")
	List<BookPojo> findBybName(String bName);

	@Query("FROM BookPojo ORDER BY price ASC")
	List<BookPojo> findAllOrderByPriceAsc();
	
	
	

}
