package com.hcl.ApteSai_week6_GradedProject.beans;

import java.util.Collection;

import java.util.List;
import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class UserBean implements UserDetails
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer uId;
	private String uName;
	private String password;
	private String type;
	
	
	public UserBean() 
	{
		super();
		// TODO Auto-generated constructor stub
	}


	public UserBean(Integer uId, String uName, String password, String type) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.password = password;
		this.type = type;
	}


	public Integer getuId() {
		return uId;
	}


	public void setuId(Integer uId) {
		this.uId = uId;
	}


	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "UserBean [uId=" + uId + ", uName=" + uName + ", password=" + password + ", type=" + type + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(password, type, uId, uName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBean other = (UserBean) obj;
		return Objects.equals(password, other.password) && Objects.equals(type, other.type)
				&& Objects.equals(uId, other.uId) && Objects.equals(uName, other.uName);
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		SimpleGrantedAuthority simple = new SimpleGrantedAuthority(this.type);
		return List.of(simple);
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return uName;
	}

	
	/*@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}*/

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	
	
	
	
	

}

