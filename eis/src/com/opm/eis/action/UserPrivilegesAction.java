package com.opm.eis.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opm.eis.model.UserPrivileges;
import com.opm.eis.service.UserPrivilegesService;

import com.opensymphony.xwork2.ActionSupport;

public class UserPrivilegesAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private Log logger = LogFactory.getLog(this.getClass());
	private UserPrivilegesService userprivilegeService;
	private UserPrivileges userprivilege;
	private List<UserPrivileges> userprivileges;
	
	private Map<String,String> map = new HashMap<String,String>();
	
	
	
	public String save()
	{
		logger.debug("in save userprivileges");
		
		if(userprivilege.getId() == null)
		{
			userprivilege.setDeleted("1");
			userprivilegeService.createUserPrivilege(userprivilege);
			addActionMessage("UserPrivilege successfully created.");
		}
		else
		{
			userprivilege.setDeleted("1");
			userprivilegeService.updateUserPrivilege(userprivilege);
			addActionMessage("UserPrivilege successfully updated.");
		}
		
		getMap().put("view", "success-page");
		return SUCCESS;
	}
	
	
	public String list()
	{
		userprivileges = userprivilegeService.getUserPrivileges();
		
		return SUCCESS;
	}
	
	public String view()
	{
		
		userprivilege = userprivilegeService.getUserPrivilegeCode(userprivilege.getUserprivilegeCode());
		userprivileges = userprivilegeService.getUserPrivileges();
		
		getMap().put("view", "view");	
		
		return SUCCESS;
	}
	
	public String add()
	{
		userprivileges = userprivilegeService.getUserPrivileges(); //list
		getMap().put("view", "add");
		
		return SUCCESS;
	}
	
	public String edit()
	{
		userprivileges = userprivilegeService.getUserPrivileges(); //list
		getMap().put("view", "edit");
		
		return SUCCESS;
	}
	
	public String input()
	{
		if(userprivilege != null && userprivilege.getId() != null)
		{
			userprivileges = userprivilegeService.getUserPrivileges(); //list
			userprivilege = userprivilegeService.getUserPrivilege(userprivilege.getId());
			
			getMap().put("view", "edit");
		}
		
		return INPUT;	
	}
	
	public String delete()
	{
		logger.debug("in method delete");
		
		if(userprivilege != null && userprivilege.getId() != null)
		{
			logger.debug("User Privilege ID is " + userprivilege.getId() );
		}
		
		userprivilegeService.deleteUserPrivilege(userprivilege);
		addActionMessage("UserPrivilege successfully deleted.");
        getMap().put("view", "success-page"); 
		
		return SUCCESS;
	}
	
	
	public void setMap(Map<String,String> map) {
		this.map = map;
	}
	public Map<String,String> getMap() {
		return map;
	}


	public UserPrivilegesService getUserprivilegeService() {
		return userprivilegeService;
	}


	public void setUserprivilegeService(UserPrivilegesService userprivilegeService) {
		this.userprivilegeService = userprivilegeService;
	}


	public UserPrivileges getUserprivilege() {
		return userprivilege;
	}


	public void setUserprivilege(UserPrivileges userprivilege) {
		this.userprivilege = userprivilege;
	}

	public List<UserPrivileges> getUserprivileges() {
		return userprivileges;
	}


	public void setUserprivileges(List<UserPrivileges> userprivileges) {
		this.userprivileges = userprivileges;
	}

}
