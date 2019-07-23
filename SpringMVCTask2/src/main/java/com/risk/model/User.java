package com.risk.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.risk.validator.IsValidPhoneNumber;

public class User {

	@NotEmpty
	@Pattern(regexp = "[^0-9]+")
	@Size(min = 6, max = 50)
	private String name;

	@Min(value = 12)
	@Max(value = 120)
	@NotNull
	private Integer age;

	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	private String country;
	
	@IsValidPhoneNumber
	private String phone; 

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User(String name, Integer age, String email, String country,String phone) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.country = country;
		this.phone = phone;
	}

	public User() {
	}

}
