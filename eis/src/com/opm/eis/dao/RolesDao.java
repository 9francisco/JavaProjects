package com.opm.eis.dao;

import java.util.List;

import com.opm.eis.model.Roles;
import com.opm.eis.model.RolesPrivileges;
import com.opm.eis.model.UserPrivileges;

public interface RolesDao {

	public void create (Roles role, List<String> listPrivileges);
	
	public List<Roles> findAll();
	
	public List<UserPrivileges> findAllPrivileges();
	
	public List<String> findSelectedPrivileges(List<String> listPrivileges);

	public Roles findById(Integer id);
	
	public Roles findByRoleCode(String roleCode);
	
	public List<RolesPrivileges> findAssignedPrivileges(String roleCode);
	
	public void update (Roles role, List<String> listPrivileges, List<String> assignedPrivilegesCode);
	
	public void delete (Roles role);
	
}
