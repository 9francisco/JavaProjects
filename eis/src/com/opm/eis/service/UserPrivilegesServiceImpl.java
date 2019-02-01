package com.opm.eis.service;

import java.util.List;

import com.opm.eis.dao.UserPrivilegesDao;
import com.opm.eis.model.UserPrivileges;

public class UserPrivilegesServiceImpl implements UserPrivilegesService {
	
	private UserPrivilegesDao userprivilegeDao;
	
	public void createUserPrivilege(UserPrivileges userprivilege) 
	{
	
		userprivilegeDao.create(userprivilege);
	}

	public UserPrivileges getUserPrivilege(Integer id) 
	{
		return userprivilegeDao.findById(id);
	}


	@Override
	public UserPrivileges getUserPrivilegeCode(String userprivilegeCode) 
	{
		return userprivilegeDao.findByUserPrivilegeCode(userprivilegeCode);
	}
	
	
	@Override
	public void deleteUserPrivilege(UserPrivileges userprivilege) {

		userprivilegeDao.delete(userprivilege);
		
	}

	@Override
	public List<UserPrivileges> getUserPrivileges() 
	{

		return userprivilegeDao.findAll();
		
	}
	
	
	@Override
	public void updateUserPrivilege(UserPrivileges userprivilege) 
	{
		userprivilegeDao.update(userprivilege);
	}

	public UserPrivilegesDao getUserprivilegeDao() {
		return userprivilegeDao;
	}

	public void setUserprivilegeDao(UserPrivilegesDao userprivilegeDao) {
		this.userprivilegeDao = userprivilegeDao;
	}
	
}
