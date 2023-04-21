package com.hcl.ApteSai_week6_GradedProject.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hcl.ApteSai_week6_GradedProject.Repo.BookRepo;
import com.hcl.ApteSai_week6_GradedProject.Repo.UserRepo;
import com.hcl.ApteSai_week6_GradedProject.beans.UserBean;


@Service
public class UserServiceImpl implements UserService
{
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	
	
	
	
	
	@Override
	public UserBean userRegister(UserBean u) 
	{
		u.setPassword(encoder.encode(u.getPassword()));
		return repo.save(u);
	}
	
	@Override
	public List<UserBean> getAllUser()
	{
		List<UserBean> courseList=(List<UserBean>)repo.findAll();
		return courseList;
	}


}

