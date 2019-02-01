package com.opm.eis.service;

import java.util.List;


import com.opm.eis.model.Offices;

public interface OfficesService {
	

		
	/**
	 * Get all User objects from 
	 * the data repository.
	 * @return Collection of User objects.
	 */
	public List<Offices> getOffices(String search_glevel,String search_officename);
	
	/**
	 * Create a User in the repository
	 * using the state of the provided
	 * User object.  Set the Id field
	 * of the provided User object
	 * to the User record's Id value.
	 * @param user User object with state
	 * to replicate in the data repository.
	 */
	public void createOffice(Offices office);
	
	/**
	 * Deletes all User objects from repository.
	 * @return number of User objects deleted.
	 */
	public int deleteAllOffices();

	/**
	 * Find the User record in the repository
	 * that has the same Id value as the User
	 * object provided.  Update that User record
	 * with the state of the provided User
	 * object.
	 * @param user User object to update.
	 */
	public void updateOffice(Offices office);

	/**
	 * Find the User record in the repository
	 * that has the same Id value as the User
	 * object provided and delete that User
	 * record.
	 * @param user User object to delete.
	 */
	public void deleteOffice(Offices office);

	/**
	 * Find the User record in the repository
	 * that has the same Id value as provided 
	 * and create a User object using that 
	 * record's column values.
	 * @param id Id value of User record.
	 * @return User object or null if no User object
	 * was found with matching Id value.
	 */

	public Offices getOfficeCode(String officeCode);
	
	public List<String> populateDetail(String search_glevel);

}

