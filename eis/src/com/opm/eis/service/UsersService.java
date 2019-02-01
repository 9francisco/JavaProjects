package com.opm.eis.service;

import java.util.List;


import com.opm.eis.model.Users;

public interface UsersService {
	

		
	/**
	 * Get all User objects from 
	 * the data repository.
	 * @return Collection of User objects.
	 */
	public List<Users> getUsers() ;
	
	/**
	 * Create a User in the repository
	 * using the state of the provided
	 * User object.  Set the Id field
	 * of the provided User object
	 * to the User record's Id value.
	 * @param user User object with state
	 * to replicate in the data repository.
	 */
	public void createUser(Users user);
	
	/**
	 * Deletes all User objects from repository.
	 * @return number of User objects deleted.
	 */
	public int deleteAllUsers();

	/**
	 * Find the User record in the repository
	 * that has the same Id value as the User
	 * object provided.  Update that User record
	 * with the state of the provided User
	 * object.
	 * @param user User object to update.
	 */
	public void updateUser(Users user);

	/**
	 * Find the User record in the repository
	 * that has the same Id value as the User
	 * object provided and delete that User
	 * record.
	 * @param user User object to delete.
	 */
	public void deleteUser(Users user);

	/**
	 * Find the User record in the repository
	 * that has the same Id value as provided 
	 * and create a User object using that 
	 * record's column values.
	 * @param id Id value of User record.
	 * @return User object or null if no User object
	 * was found with matching Id value.
	 */
	public Users getUser(Integer id);
	
	public Users getUserID(String userID);
	
	
	/**
	 * Validates the loginStatus for the user
	 * @param user
	 * @return Boolean value true if user exist
	 */
	public boolean validateUser(String userID, String password);
	
	public boolean verifyPassword(String userID, String newpassword, String oldpassword);
	
	public void logoutUser(String userID);

}

