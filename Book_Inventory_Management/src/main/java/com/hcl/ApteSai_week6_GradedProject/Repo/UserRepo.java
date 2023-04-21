package com.hcl.ApteSai_week6_GradedProject.Repo;

import java.util.Optional;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hcl.ApteSai_week6_GradedProject.beans.UserBean;



public interface UserRepo extends CrudRepository<UserBean, Integer>
{
	
	UserBean findByuName(String uName);


}
