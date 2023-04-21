package com.hcl.ApteSai_week6_GradedProject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hcl.ApteSai_week6_GradedProject.Repo.UserRepo;
import com.hcl.ApteSai_week6_GradedProject.beans.UserBean;


@Service
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String uName) throws UsernameNotFoundException 
	{
		/*UserBean user=null ;
		try 
		{
			user= repo.findByuName(uName).orElseThrow(()->new Exception("user not found"));
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
		return user;*/
		
		
		UserBean user= repo.findByuName(uName);
		return new org.springframework.security.core.userdetails.User(user.getuName(),user.getPassword(),new ArrayList()) ;

		
	}


}
