package com.hcl.ApteSai_week6_GradedProject.Config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BeanConfig 
{

	@Bean 
	public BCryptPasswordEncoder getEncoder()
	{
		return new BCryptPasswordEncoder();
	}


	
}

