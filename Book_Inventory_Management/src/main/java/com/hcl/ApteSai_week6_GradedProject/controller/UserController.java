package com.hcl.ApteSai_week6_GradedProject.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ApteSai_week6_GradedProject.JwtUtil.JwtUtil;
import com.hcl.ApteSai_week6_GradedProject.Repo.BookRepo;
import com.hcl.ApteSai_week6_GradedProject.beans.UserBean;
import com.hcl.ApteSai_week6_GradedProject.service.UserService;

@RestController//= @Controller + @ResponseBody
@RequestMapping("/you.com")
public class UserController 
{
	@Autowired
	UserService service;
	
	//@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value="/",consumes=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<UserBean> registerUser(@RequestBody UserBean user)
	{

		UserBean u=service.userRegister(user); 
		return new ResponseEntity<UserBean>(user,HttpStatus.CREATED);
	 
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserBean>> getAllUser()
	{
		List<UserBean> courseList= service.getAllUser();
		return new ResponseEntity<>(courseList,HttpStatus.OK);
	}

	
	@Autowired 
	JwtUtil jwtUtil;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@GetMapping("/welcom")
	public String welcome()
	{
		return "Welcome Dear User";
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public String  loginUser(@RequestBody UserBean user) throws Exception
	{
       try {
    	   authenticationManager
   		.authenticate(new UsernamePasswordAuthenticationToken(user.getuName()
   				,user.getPassword()));
	} catch (Exception e) {
		throw new Exception("invalid credentials");
	}
		return jwtUtil.generateToken(user.getuName());
	}
	


}