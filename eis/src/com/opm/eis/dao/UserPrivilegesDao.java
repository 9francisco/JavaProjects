package com.opm.eis.dao;

import java.util.List;

import com.opm.eis.model.UserPrivileges;

public interface UserPrivilegesDao {
	
	public void create (UserPrivileges userprivilege);
	
	public List<UserPrivileges> findAll();

	public UserPrivileges findById(Integer id);
	
	public UserPrivileges findByUserPrivilegeCode(String userprivilegeCode);
	
	public void update (UserPrivileges userprivilege);
	
	public void delete (UserPrivileges userprivilege);

}
