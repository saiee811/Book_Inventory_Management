package com.hcl.ApteSai_week6_GradedProject;

import java.util.Optional;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;



import com.hcl.ApteSai_week6_GradedProject.Repo.BookRepo;
import com.hcl.ApteSai_week6_GradedProject.beans.BookPojo;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class ApteSaiWeek6GradedProjectApplicationTests 
{
	
	@Autowired
	BookRepo repo;

	@Order(1)
	@Test
	@Rollback(value=false)
	void getBookTest() 
	{
	
		 Optional<BookPojo> e = repo.findById(1);
		
		Assertions.assertThat(e.get().getbId()).isEqualTo(1);
		
	}
	
	@Order(1)
	@Test
	@Rollback(value=false)
	void addBookTest() 
	{
		BookPojo e = new BookPojo(14,"saiee","Spring the problem", "Where all problems start",600);
		repo.save(e);
		
		Assertions.assertThat(e.getbId()).isGreaterThan(0);
		
	}

	


}


