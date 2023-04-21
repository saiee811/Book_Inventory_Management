package com.hcl.ApteSai_week6_GradedProject.beans;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class BookPojo 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bId;
	private String bName;
	private String author;
	private String description;
	private Integer price;
	
	
	
	public BookPojo() 
	{
		super();
		// TODO Auto-generated constructor stub
	}



	public BookPojo(Integer bId, String bName, String author, String description, Integer price) 
	{
		super();
		this.bId = bId;
		this.bName = bName;
		this.author = author;
		this.description = description;
		this.price = price;
	}



	public Integer getbId() {
		return bId;
	}



	public void setbId(Integer bId) {
		this.bId = bId;
	}



	public String getbName() {
		return bName;
	}



	public void setbName(String bName) {
		this.bName = bName;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Integer getPrice() {
		return price;
	}



	public void setPrice(Integer price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "BookPojo [bId=" + bId + ", bName=" + bName + ", author=" + author + ", description=" + description
				+ ", price=" + price + "]";
	}



	@Override
	public int hashCode() 
	{
		return Objects.hash(author, bId, bName, description, price);
	}



	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookPojo other = (BookPojo) obj;
		return Objects.equals(author, other.author) && Objects.equals(bId, other.bId)
				&& Objects.equals(bName, other.bName) && Objects.equals(description, other.description)
				&& Objects.equals(price, other.price);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
