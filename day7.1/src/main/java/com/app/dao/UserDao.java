package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import com.app.entities.Role;
import com.app.entities.User;


public interface UserDao {
//add a method for user sign up
	String registerUser(User user);
	//add a method to get user details by it's id
	User getUserDetails(Long userId);
	
	//add a method to return list of all users
	List<User> getAllUsers();
	
	
	
	
	
	/*
	 * 12. Objective : Display all users born between strt date n end date & under a
	 * specific role I/P : begin dt , end date , role eg : sql = select * from users
	 * where dob between ? and ? and user_role=? 
	 */
	List<User> getAllUsersByDobAndRole(LocalDate start, LocalDate end, Role role);
	
	
	
	
	
	/*
	 * 13. User Login (Lab work) i/p : email n password o/p User details with
	 * success mesg or invalid login mesg
	 */
	User loginUser(String email,String password);
	
	
	
	
	
	//add a method for user's change password
	String changePassword(String email, String password,String newPassword);
	
	
	
}
