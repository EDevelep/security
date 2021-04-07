package com.example.demo.controller;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;


import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "userdetail")
@Data
public class UserDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;

	@Column(name="username",length = 10)
	//@NotEmpty(message = "Username name is Mandatory field. Please provide user name")
	private String username;
	
	
	@Column(name="emailid",length = 20)
	//@NotEmpty(message = "Email is required")
    @Email
	private String emailid;
	
	@Column(name="password",length = 20, nullable = false)
	//@NotEmpty(message = "Password  is Mandatory field. Please provide Password")
	//@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,15}$",
   // message="Password should at least 8 characters and at most 15 characters, at least one digit, one upper/lower case alphabet, one special character which includes !@#$%&*()-+=^, doesn’t contain any white space")
	private String password;
	
	@Column(name="surname",length = 10)
	//@NotEmpty(message = "Surname  is Mandatory field. Please provide Surname ")
	private String surname;
	@Column(name="pincode",length = 30)
//	@NotBlank(message = "Pincode  is Mandatory field. Please provide Pincode")
	private String pincode;
	
	@Column(name="dateofbirth",length = 10)
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private Date dateofbirth;
	
	@Column(name="joiningdate",length = 20)
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private Date joiningdate;
	
	@Column(name="active",length = 2)
	private char active;
	
	
	
	
	

}
