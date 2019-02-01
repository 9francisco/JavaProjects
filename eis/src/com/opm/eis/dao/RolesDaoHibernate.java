package com.opm.eis.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.opm.eis.model.Roles;
import com.opm.eis.model.UserPrivileges;
import com.opm.eis.model.RolesPrivileges;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("roleDao")
public class RolesDaoHibernate extends HibernateDaoSupport implements RolesDao {
	
	@Transactional
	public void create(Roles role, List<String> listPrivileges) 
	{
		//save role
		getHibernateTemplate().saveOrUpdate(role);

		//save role privileges
		for (int i=0;i < listPrivileges.size();i++)
		{
			RolesPrivileges rolePrivileges = new RolesPrivileges();
			
			rolePrivileges.setRoleCode(role.getRoleCode());
			rolePrivileges.setRolePrivilegeCode(listPrivileges.get(i));
			
			//Get privilege description
			getPrivilegeDescription(rolePrivileges, listPrivileges.get(i));
			
			getHibernateTemplate().saveOrUpdate(rolePrivileges);
		}
			
	}

	
	//method use locally
	public void getPrivilegeDescription(RolesPrivileges rolePrivileges, String privilegeCode)
	{
		Query query = getSession().createQuery("from UserPrivileges where userprivilegeCode = :code");
		query.setParameter("code", privilegeCode);
		UserPrivileges userPriv = (UserPrivileges) query.uniqueResult();
		
		rolePrivileges.setRolePrivilegeDescription(userPriv.getUserprivilegeDesc());
	}	
	
	@Transactional
	public Roles findById(Integer id) 
	{
		return (Roles) getHibernateTemplate().get(Roles.class, id);
	}

	@Override
	@Transactional
	public Roles findByRoleCode(String roleCode) 
	{
		Query query = getSession().getNamedQuery("role.findByRoleCode");

		query.setString("rolecode", roleCode);
		
		Roles role = (Roles) query.uniqueResult();
		
		System.out.print("Print roleCode: "+ roleCode);
		
		return role;			
	}	
	
	@SuppressWarnings("unchecked")
	@Transactional (readOnly=true)
	public List<Roles> findAll() 
	{
		return getHibernateTemplate().find("from Roles where DELETED = '1'");
		
	}

	@Override
	public void update(Roles role, List<String> listPrivileges, List<String> assignedPrivilegesCode) 
	{
		//update role
		getHibernateTemplate().saveOrUpdate(role);
		
		//update privileges, delete unchecked and insert newly checked privileges
		for (int i=0; i < assignedPrivilegesCode.size(); i++)
		{
			boolean delete = false;
			
			for(int j=0; j < listPrivileges.size(); j++)
			{	
				//System.out.println("AP: " + assignedPrivilegesCode.get(i) + " vs LP: " +  listPrivileges.get(j));
				
				if (assignedPrivilegesCode.get(i).equals(listPrivileges.get(j)))
				{
					j = listPrivileges.size();
					delete = false;
				}	
				else
				{
					delete = true;
				}
			}
			
			if (delete)
			{
				Query query = getSession().createQuery("DELETE RolesPrivileges WHERE rolePrivilegeCode = :code");
				query.setParameter("code", assignedPrivilegesCode.get(i));
				System.out.println("0");
				query.executeUpdate();
				System.out.println("1");
				getSession().flush();
				System.out.println("2");
				getSession().clear();
				System.out.println("3");
			}
		}
		
		//insert new privileges
		for (int i=0; i < listPrivileges.size(); i++)
		{
			boolean insert = false;
			
			for(int j=0; j < assignedPrivilegesCode.size(); j++)
			{	
				if (listPrivileges.get(i).equals(assignedPrivilegesCode.get(j)))
				{
					j = assignedPrivilegesCode.size();
					insert = false;
				}	
				else
				{
					insert = true;
				}
			}
			
			if (insert)
			{
		        RolesPrivileges rolePrivileges = new RolesPrivileges();
		        
		        rolePrivileges.setRoleCode(role.getRoleCode());
		        rolePrivileges.setRolePrivilegeCode(listPrivileges.get(i));
		        
		        //get privilege description
				getPrivilegeDescription(rolePrivileges, listPrivileges.get(i));
				
				getHibernateTemplate().saveOrUpdate(rolePrivileges);
			}
		}
	
	}

	@SuppressWarnings("unchecked")
	public List<UserPrivileges> findAllPrivileges() 
	{		
		return getHibernateTemplate().find("from UserPrivileges");
	}	

	@Override
	public List<String> findSelectedPrivileges(
			List<String> listPrivileges)
	{
		List<String> rolePrivDesc = new ArrayList<String>();
		
		for (int i=0;i < listPrivileges.size();i++)
		{
			Query query = getSession().createQuery("from UserPrivileges where userprivilegeCode = :code");
			query.setParameter("code", listPrivileges.get(i));
			UserPrivileges userPriv = (UserPrivileges) query.uniqueResult();
				
			rolePrivDesc.add(userPriv.getUserprivilegeDesc());
		}
		
		return rolePrivDesc;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RolesPrivileges> findAssignedPrivileges(String roleCode) 
	{
		return getHibernateTemplate().find("from RolesPrivileges WHERE ROLE_CODE = '"+roleCode+"'");
	
	}	
	
	@Transactional
	@Override
	public void delete (Roles role) {
		
		String deletedrole = "UPDATE Roles SET DELETED=0 WHERE ID='"+role.getId()+"'";
		Query query = getSession().createQuery(deletedrole);
		query.executeUpdate();		
		
	}
	
}
