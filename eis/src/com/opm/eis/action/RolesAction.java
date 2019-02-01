package com.opm.eis.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opm.eis.model.Roles;
import com.opm.eis.model.UserPrivileges;
import com.opm.eis.model.RolesPrivileges;

import com.opm.eis.service.RolesService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

public class RolesAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Log logger = LogFactory.getLog(this.getClass());
	private RolesService roleService;
	private Roles role;
	private List<Roles> roles;
	
	private RolesPrivileges rolePrivileges = new RolesPrivileges();
	private List<UserPrivileges> privileges;
	private List<String> listPrivileges; //add: for users' checked privileges [stores the code]
	private List<String> listSelectedPrivileges; //add: to display description of privileges
	private List<RolesPrivileges> assignedPrivileges; //view|edit: to store privileges assigned to a role
	private List<String> assignedPrivilegesCode = new ArrayList<String>(); //edit: to store codes of privileges for pre-selected values in checkboxlist
	
	private Map<String,String> map = new HashMap<String,String>();
	
	private Integer rolePrivTotal;
	private Integer privilegesTotal;	
	
	public RolesAction(RolesService roleService) {
		this.roleService = roleService;
	}
	
	
	public String save()
	{
		logger.debug("in save roles");
		
		if(role.getId() == null)
		{
			role.setDeleted("1");
			roleService.createRole(role, listPrivileges);
			addActionMessage("Role successfully created.");
		}
		else
		{

			//get previously assigned privileges
			listAssignedPrivileges();
			role.setDeleted("1");
			roleService.updateRoles(role, listPrivileges, assignedPrivilegesCode);
			addActionMessage("Role successfully updated.");
			
		}
		
		getMap().put("view", "success-page");
		return SUCCESS;
	}
	
	
	public String list()
	{
		roles = roleService.getRoles();
		return SUCCESS;
	}

	public void listPrivileges()
	{
		privileges = roleService.getPrivileges();
		System.out.println(privileges.size());
		
	}
	
	public void listAssignedPrivileges()
	{
		assignedPrivileges = roleService.getAssignedPrivileges(role.getRoleCode());
		
		for (int i=0;i < assignedPrivileges.size();i++)
		{					
			assignedPrivilegesCode.add(assignedPrivileges.get(i).getRolePrivilegeCode());
		}
		
		System.out.println("assigned: " + assignedPrivilegesCode);		
	}	
	
	public String view()
	{
		//System.out.println("view role details");
		//System.out.println(role.getId());
		
		role = roleService.getRoleCode(role.getRoleCode());
		assignedPrivileges = roleService.getAssignedPrivileges(role.getRoleCode());
		
		roles = roleService.getRoles();
		
		getMap().put("view", "view");	
		
		return SUCCESS;
	}

	public String populate()
	{
		System.out.println("populate privileges");
		getMap().put("populate", "");
		
		privilegesTotal = listPrivileges.size();
		
		if (privilegesTotal > 0)
		{
			getMap().put("populate","privileges");
			//listSelectedPrivileges = roleService.getSelectedPrivileges(listPrivileges);
			
			System.out.println(listPrivileges);
			System.out.println(listSelectedPrivileges);
			
		}
		
		
		return SUCCESS;
	}	
	
	public String add()
	{
		roles = roleService.getRoles(); //list
		getMap().put("view", "add");

		//list all privileges available
		listPrivileges();		
		
		return SUCCESS;
	}
	
	public String edit()
	{
		roles = roleService.getRoles(); //list
		getMap().put("view", "edit");
		
		return SUCCESS;
	}
	
	public String input()
	{
		if(role != null && role.getId() != null)
		{
			//System.out.println("editing role");
			roles = roleService.getRoles(); //list
			role = roleService.getRole(role.getId());

			//list all privileges available
			listPrivileges();
			
			//list assigned privileges of role
			listAssignedPrivileges();			
			
			getMap().put("view", "edit");
		}
		
		return INPUT;	
	}
	
	public String delete()
	{
		logger.debug("in method delete");
		
		if(role != null && role.getId() != null)
		{
			//System.out.println("delete role");
			logger.debug("Role ID is " + role.getId() );
		}
		
		roleService.deleteRole(role);
        addActionMessage("Role successfully deleted.");
        getMap().put("view", "success-page"); 		
		
		return SUCCESS;
	}
	
	
	
	
	
	public void setRole(Roles role) {
		this.role = role;
	}
	public Roles getRole() {
		return role;
	}


	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	public List<Roles> getRoles() {
		return roles;
	}


	public void setMap(Map<String,String> map) {
		this.map = map;
	}
	public Map<String,String> getMap() {
		return map;
	}

	public void setRoleService(RolesService roleService) {
		this.roleService = roleService;
	}


	public RolesService getRoleService() {
		return roleService;
	}

	public void setRolePrivTotal(Integer rolePrivTotal) {
		this.rolePrivTotal = rolePrivTotal;
	}


	public Integer getRolePrivTotal() {
		return rolePrivTotal;
	}

	public List<UserPrivileges> getPrivileges() {
		return privileges;
	}


	public void setPrivileges(List<UserPrivileges> privileges) {
		this.privileges = privileges;
	}


	public List<String> getListPrivileges() {
		return listPrivileges;
	}


	public void setListPrivileges(List<String> listPrivileges) {
		this.listPrivileges = listPrivileges;
	}


	public void setPrivilegesTotal(Integer privilegesTotal) {
		this.privilegesTotal = privilegesTotal;
	}


	public Integer getPrivilegesTotal() {
		return privilegesTotal;
	}


	public void setRolePrivileges(RolesPrivileges rolePrivileges) {
		this.rolePrivileges = rolePrivileges;
	}


	public RolesPrivileges getRolePrivileges() {
		return rolePrivileges;
	}


	public void setListSelectedPrivileges(List<String> listSelectedPrivileges) {
		this.listSelectedPrivileges = listSelectedPrivileges;
	}


	public List<String> getListSelectedPrivileges() {
		return listSelectedPrivileges;
	}


	public void setAssignedPrivileges(List<RolesPrivileges> assignedPrivileges) {
		this.assignedPrivileges = assignedPrivileges;
	}


	public List<RolesPrivileges> getAssignedPrivileges() {
		return assignedPrivileges;
	}

	public List<String> getAssignedPrivilegesCode() {
		return assignedPrivilegesCode;
	}

	public void setAssignedPrivilegesCode(List<String> assignedPrivilegesCode) {
		this.assignedPrivilegesCode = assignedPrivilegesCode;
	}	
	
	

}
