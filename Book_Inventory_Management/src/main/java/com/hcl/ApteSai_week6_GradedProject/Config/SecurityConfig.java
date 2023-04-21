package com.hcl.ApteSai_week6_GradedProject.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hcl.ApteSai_week6_GradedProject.JwtFilter.JwtFilter;
import com.hcl.ApteSai_week6_GradedProject.service.CustomUserDetailsService;




@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	CustomUserDetailsService userDetailsService;
	
	
	@Autowired
	JwtFilter jwtFilter;

	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	
	@Bean(name=BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	  auth.userDetailsService(userDetailsService);
	}

	

	/*protected void configure(HttpSecurity http) throws Exception 
	{
		
	   

		http.csrf().disable()
		.authorizeRequests().antMatchers("/Admin/**").hasAuthority("Admin")
		.antMatchers("/User/**").hasAuthority("User")
		.antMatchers("/you.com/**").permitAll();
		super.configure(http);
		
		
    	 
	}*/
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.cors().disable();
		http.csrf().disable()
		.authorizeRequests().antMatchers("/Admin/**").permitAll()
		.antMatchers("/User/**").permitAll()
		.antMatchers("/you.com/**").permitAll()
		.and().exceptionHandling().and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
		 http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class );
		 super.configure(http);

		
	}
	
	
	

	

	

}
