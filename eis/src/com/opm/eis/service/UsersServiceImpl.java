package com.opm.eis.service;

import java.util.List;

import com.opm.eis.dao.UsersDao;
import com.opm.eis.model.Users;

public class UsersServiceImpl implements UsersService {
	
	private UsersDao userDao;
	

	
	public Users getUser(Integer id) {
		
		return userDao.findById(id);
		
	}

	public Users getUserID(String userID) {
		
		return userDao.findByUserID(userID);
		
	}

	
	public List<Users> getUsers() {
		
		return userDao.findAll();
		
	}
	
	
	public void createUser(Users user) {
		
		userDao.create(user);
		
	}
	
	
	public void deleteUser(Users user) {
		
		userDao.delete(user);
		
	}
	
	
	public int deleteAllUsers() {
		
		return userDao.deleteAll();
		
	}
	
	
	public void updateUser(Users user) {
		
		userDao.update(user);
		
	}
	
	public boolean validateUser(String userID, String password) {
		
		return userDao.validate(userID,password);
	}

	public boolean verifyPassword (String userID, String newpassword, String oldpassword) {
		
		return userDao.verifyPW(userID,newpassword,oldpassword);
	}
	
	public void logoutUser(String userID) {
		
		System.out.println("log-User");
		
		userDao.loggedout(userID);
	}
	
	public UsersDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UsersDao userDao) {
		this.userDao = userDao;
	}
}
