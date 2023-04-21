package com.hcl.ApteSai_week6_GradedProject.service;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.ApteSai_week6_GradedProject.beans.UserBean;

@Service
public interface UserService 
{
		
	UserBean userRegister(UserBean u);

	List<UserBean> getAllUser();

	


}
