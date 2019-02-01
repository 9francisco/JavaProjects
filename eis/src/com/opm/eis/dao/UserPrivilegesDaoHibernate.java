package com.opm.eis.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;


import com.opm.eis.model.UserPrivileges;

@Repository("userprivilegeDao")
public class UserPrivilegesDaoHibernate extends HibernateDaoSupport implements UserPrivilegesDao{
	
	@Transactional
	//@SuppressWarnings("unchecked")
	public void create(UserPrivileges userprivilege) 
	{
		
		/*
		String hql = "SELECT userprivilegeCode from UserPrivileges";
		Query query = getSession().createQuery(hql);
		List<String> privilegelist = query.list();
		System.out.print("Print privilegelist: "+ privilegelist);
		*/
		getHibernateTemplate().saveOrUpdate(userprivilege);
		
	}

	@Transactional
	public UserPrivileges findById(Integer id) 
	{
		return (UserPrivileges) getHibernateTemplate().get(UserPrivileges.class, id);
	}

	@Override
	@Transactional
	public UserPrivileges findByUserPrivilegeCode(String userprivilegeCode) 
	{
		Query query = getSession().getNamedQuery("userprivilege.findByUserPrivilegeCode");

		query.setString("userprivilegecode", userprivilegeCode);
		
		UserPrivileges userprivilege = (UserPrivileges) query.uniqueResult();
		
		//System.out.print("Print userprivilegeCode: "+ userprivilegeCode);
		
		return userprivilege;			
	}	
	
	@SuppressWarnings("unchecked")
	@Transactional (readOnly=true)
	public List<UserPrivileges> findAll() 
	{
		
		return getHibernateTemplate().find("from UserPrivileges where DELETED = '1'");
		
	}

	@Override
	public void update(UserPrivileges userprivilege) 
	{
		getHibernateTemplate().saveOrUpdate(userprivilege);
		
	}

	
	@Override
	@Transactional
	public void delete(UserPrivileges userprivilege) {
	
		String deleteduserprivilege = "UPDATE UserPrivileges SET DELETED=0 WHERE ID='"+userprivilege.getId()+"'";
		Query query = getSession().createQuery(deleteduserprivilege);
		query.executeUpdate();
		
	}

}
