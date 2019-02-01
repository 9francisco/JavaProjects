package com.opm.eis.dao;

import java.util.List;

import com.opm.eis.model.Users;

public interface UsersDao {

	/**
	 * Create a User in the repository
	 * using the state of the provided
	 * User object.  Set the Id field
	 * of the provided User object
	 * to the User record's Id value.
	 * @param user User object with state
	 * to replicate in the data repository.
	 */
	 public void create(Users user) ;
	
	/**
	 * Get all User objects from 
	 * the data repository.
	 * @return Collection of User objects.
	 */
	 public List<Users> findAll();
	 
	/**
	 * Find the User record in the repository
	 * that has the same Id value as provided 
	 * and create a User object using that 
	 * record's column values.
	 * @param id Id value of User record.
	 * @return User object or null if no User object
	 * was found with matching Id value.
	 */
	 public Users findById(Integer id);
	 
	/**
	 * Find the User record in the repository
	 * that has the same Id value as the User
	 * object provided.  Update that User record
	 * with the state of the provided User
	 * object.
	 * @param user User object to update.
	 */
	 public void update(Users user);
	 
	/**
	 * Find the User record in the repository
	 * that has the same Id value as the User
	 * object provided and delete that User
	 * record.
	 * @param user User object to delete.
	 */
	 public void delete(Users user);
	 
	 public Users findByUserID(String userID);
	 
	 public int deleteAll();
	 
	 public boolean validate(String userID, String password);
	 
	 public void loggedout(String userID);
	 
	 public boolean verifyPW(String userID, String newpassword, String oldpassword);
}