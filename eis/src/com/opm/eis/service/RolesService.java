package com.opm.eis.service;

import java.util.List;

import com.opm.eis.model.Roles;
import com.opm.eis.model.RolesPrivileges;
import com.opm.eis.model.UserPrivileges;

public interface RolesService {

	public List<Roles> getRoles();
	
	public List<UserPrivileges> getPrivileges();
	
	public List<String> getSelectedPrivileges(List<String> listPrivileges);
	
	public void createRole(Roles role,List<String> listPrivileges);
	
	public void updateRoles(Roles role, List<String> listPrivileges, List<String> assignedPrivilegesCode);
	
	public void deleteRole(Roles role);

	public Roles getRole(Integer id);
	
	public Roles getRoleCode(String roleCode);
	
	public List<RolesPrivileges> getAssignedPrivileges(String roleCode);
	
}
