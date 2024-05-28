package com.app.beans;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

public class UserBean {
//state -- request params from clnt mapped to Java bean properties
	//add more properties for voter registration
	private String firstName;
	private String lastName;
	private String dob;//dob: string since WC cannot translate from string to non primitive types
	private String email;
	private String password;
	//dependency -- dao layer
	private UserDaoImpl userDao;
	//add a property to store validated user details
	private User userDetails;
	private String message;
	//def ctor 
	public UserBean() throws SQLException{
		// create dao instance
		userDao=new UserDaoImpl();
		System.out.println("user bean created...");
	}
	//getter n setter
	
	public String getEmail() {
		return email;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserDaoImpl getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}
	public User getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}
	
	public String getMessage() {
		return message;
	}
	//Add B.L method for user authentication
	public String validateUser() throws SQLException{
		System.out.println("in validate user "+email+" "+password);
		//bean --> invokes dao's method
		userDetails=userDao.signIn(email, password);
		if(userDetails == null) {
			//invalid login
			message="Invalid Email or Password , Please retry!";
			return "login";//navigetional outcome to JSP(tells JSP,where to take the clinent)
		}
		//=> valid login --> chk role based authorization
		message="Login Successful!";
		if(userDetails.getRole().equals("admin"))
			return "admin_main";
		//=> voter login
		if(userDetails.isStatus())
			return "logout";
		//not yet voted
		return "candidate_list";
	}
	
	
	//add a BL mehod for validating inputs n then registration
	public String validateAndRegister() throws SQLException
	{
		//parse dob=> local date and validate
		//in case of invalid age => return error message
		//other wise invoke dao's method for registration
		LocalDate birthdate=LocalDate.parse(dob);
		int age=Period.between(birthdate, LocalDate.now()).getYears();
		if(age<21)
		{
			return "Registration failed!!!";
		}
		//=>valid age
		
		String regStatus=userDao.voterRegistration(new User(firstName,lastName,email,password,Date.valueOf(birthdate)));
		return regStatus;
	}
	
	
	
}
