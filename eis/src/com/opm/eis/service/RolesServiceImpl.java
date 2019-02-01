package com.opm.eis.service;

import java.util.List;

import com.opm.eis.model.Roles;
import com.opm.eis.model.RolesPrivileges;
import com.opm.eis.model.UserPrivileges;
import com.opm.eis.dao.RolesDao;


public class RolesServiceImpl implements RolesService{

	private RolesDao roleDao;
	
	public void createRole(Roles role, List<String> listPrivileges) 
	{
		roleDao.create(role, listPrivileges);
	}

	public Roles getRole(Integer id) 
	{
		return roleDao.findById(id);
	}


	@Override
	public Roles getRoleCode(String roleCode) 
	{
		return roleDao.findByRoleCode(roleCode);
	}
	
	
	
	
	
	@Override
	public void deleteRole(Roles role) 
	{

		roleDao.delete(role);
		
	}
	


	@Override
	public List<Roles> getRoles() 
	{

		return roleDao.findAll();
		
	}
	
	
	@Override
	public void updateRoles(Roles role, List<String> listPrivileges, List<String> assignedPrivilegesCode) 
	{
		roleDao.update(role, listPrivileges, assignedPrivilegesCode);
	}
	
	
	
	public RolesDao getRoleDao()
	{
		return roleDao;
	}
	
	public void setRoleDao(RolesDao roleDao)
	{
		this.roleDao = roleDao;
	}

	@Override
	public List<UserPrivileges> getPrivileges() 
	{
		return roleDao.findAllPrivileges();
	}

	@Override
	public List<String> getSelectedPrivileges(
			List<String> listPrivileges) 
	{
		return roleDao.findSelectedPrivileges(listPrivileges);
	}

	@Override
	public List<RolesPrivileges> getAssignedPrivileges(String roleCode) 
	{
		return roleDao.findAssignedPrivileges(roleCode);
	}

}
