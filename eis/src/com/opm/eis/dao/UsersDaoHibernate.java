package com.opm.eis.dao;

import java.util.List;
import java.util.*;


import com.opm.eis.model.Users;
import com.opm.eis.model.UserPasswords;
import com.opm.eis.utils.DateUtils; 

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDao")
public class UsersDaoHibernate extends HibernateDaoSupport implements UsersDao {

	DateUtils dateutils = new DateUtils();
	
	public DateUtils getDateutils() {
		return dateutils;
	}

	public void setDateutils(DateUtils dateutils) {
		this.dateutils = dateutils;
	}

	@Transactional
	public void create(Users user) {
		
		getHibernateTemplate().saveOrUpdate(user);

	}

	@Transactional
	public void delete(Users user) {

		//int deleteduser = (int) user.getId();
		//System.out.println("deleted user "+deleteduser);
        //getHibernateTemplate().delete(user);

		String deleteduser = "UPDATE Users SET DELETED=0 WHERE ID='"+user.getId()+"'";
		Query query = getSession().createQuery(deleteduser);
		query.executeUpdate();


	}
	
	
	@Transactional
	public boolean validate(String userID, String password) {
		
		loggedin(userID);
		
		boolean loginStatus;

		String hql = "from Users where USERID='"+userID+"' and PASSWORD='"+password+"'";

		Query query = getSession().createQuery(hql);

		Users user = (Users) query.uniqueResult();		
		
		if (user==null){
			
			loginStatus = false;
		}
		else 
		{
			loginStatus = true;
		}
	
		
        return loginStatus;

	}
	
	public void loggedin(String userID){
		
		System.out.println("Logged-in");

		String loggedindate = new String();
		
		loggedindate = dateutils.sendDate();
				
		String loggedin = "UPDATE Users SET STATUS=true, LAST_LOGIN_DATE=TO_DATE('"+loggedindate+"', 'mm/dd/yyyy hh24:mi:ss') WHERE USERID='"+userID+"'";
		Query query = getSession().createQuery(loggedin);
		query.executeUpdate();
		
	}
	
	public void loggedout(String userID){
		
		System.out.println("Logged-out");
		String loggedout = "UPDATE Users SET STATUS=false WHERE USERID='"+userID+"'";
		Query query = getSession().createQuery(loggedout);
		query.executeUpdate();
		
	}
	
	
	@Transactional
	 public boolean verifyPW(String userID, String newpassword, String oldpassword){
		 
		System.out.println("Change password");	

		boolean verified;

		String loggedindate = new String();
		loggedindate = dateutils.sendDate();
		int success;
		int pwcheck = passwordChk(userID,newpassword,oldpassword);

		if (pwcheck==1){
		
			String loggedin = "UPDATE Users SET PASSWORD='"+newpassword+"', LAST_PWD_CHANGE=TO_DATE('"+loggedindate+"', 'mm/dd/yyyy hh24:mi:ss') WHERE USERID='"+userID+"'";
			Query query = getSession().createQuery(loggedin);
			success = query.executeUpdate();
		
		}
		
		else {
			
			success = 0;
		}
		
		
		
		if(success==1){
			verified = true;
		}
		else {
			verified = false;
		}
		 
		return verified;
	 }

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Users> findAll() {
		
		return getHibernateTemplate().find("from Users where DELETED = '1' ORDER BY lastName");
		
	}

	@Transactional
	public Users findById(Integer id) {

		return (Users) getHibernateTemplate().get(Users.class, id);
		
	}
	

	@Transactional
	public void update(Users user) {
		
		getHibernateTemplate().saveOrUpdate(user);

	}

	@Transactional
	public Users findByUserID(String userID) {
		
		Query query = getSession().getNamedQuery("user.findByUserID");
		
		query.setString("userid", userID);
		
		Users user = (Users) query.uniqueResult();
		
		return user;	
		
	}

	@Transactional
	public int deleteAll() {
		
		String hql = "delete Users";
		
		Query query = getSession().createQuery(hql);
		
		int rowCount = query.executeUpdate();
		
		return rowCount;	
		
	}
	
	public int passwordChk (String userID,String newpassword,String oldpassword){
		
		//if true
		
		//Insert userID,old password,change_date 
		Date pwchangedate = Calendar.getInstance().getTime();
		
		UserPasswords userpassword = new UserPasswords();
		userpassword.setUserID(userID);
		userpassword.setPassword(oldpassword);
		userpassword.setChangeDate(pwchangedate);
		getHibernateTemplate().saveOrUpdate(userpassword);
		
		//String loggedin = "UPDATE Users SET STATUS=true, LAST_LOGIN_DATE=TO_DATE('"+loggedindate+"', 'mm/dd/yyyy hh24:mi:ss') WHERE USERID='"+userID+"'";
		//Query query = getSession().createQuery(loggedin);
		//query.executeUpdate();		
		
		
		//Check userID count: If userIDcount < 5
			//Insert userID,old password,change_date
		
		
		return 1;
	}

}

