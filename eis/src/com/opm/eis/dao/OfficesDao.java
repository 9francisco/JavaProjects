package com.opm.eis.dao;

import java.util.List;

import com.opm.eis.model.Offices;

public interface OfficesDao {

	/**
	 * Create a User in the repository
	 * using the state of the provided
	 * User object.  Set the Id field
	 * of the provided User object
	 * to the User record's Id value.
	 * @param user User object with state
	 * to replicate in the data repository.
	 */
	 public void create(Offices office) ;
	
	/**
	 * Get all User objects from 
	 * the data repository.
	 * @return Collection of User objects.
	 */
	 public List<Offices> findAll(String search_glevel,String search_officename);
	 
	/**
	 * Find the User record in the repository
	 * that has the same Id value as provided 
	 * and create a User object using that 
	 * record's column values.
	 * @param id Id value of User record.
	 * @return User object or null if no User object
	 * was found with matching Id value.
	 */
	 public Offices findByOfficeCode(String officeCode);
	 
	/**
	 * Find the User record in the repository
	 * that has the same Id value as the User
	 * object provided.  Update that User record
	 * with the state of the provided User
	 * object.
	 * @param user User object to update.
	 */
	 public void update(Offices office);
	 
	/**
	 * Find the User record in the repository
	 * that has the same Id value as the User
	 * object provided and delete that User
	 * record.
	 * @param user User object to delete.
	 */
	 public void delete(Offices office);
	 
 
	 public int deleteAll();
	 
	 public List<String> listofficename(String search_glevel);
	 

}