package com.opm.eis.service;

import java.util.List;

import com.opm.eis.model.UserPrivileges;

public interface UserPrivilegesService {
	
	public List<UserPrivileges> getUserPrivileges();
	
	public void createUserPrivilege(UserPrivileges userprivilege);
	
	public void updateUserPrivilege(UserPrivileges userprivilege);
	
	public void deleteUserPrivilege(UserPrivileges userprivilege);

	public UserPrivileges getUserPrivilege(Integer id);
	
	public UserPrivileges getUserPrivilegeCode(String userprivilegeCode);	

}
