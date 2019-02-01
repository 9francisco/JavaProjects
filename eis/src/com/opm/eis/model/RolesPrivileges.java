package com.opm.eis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="ROLES_PRIVILEGES")

public class RolesPrivileges {
	
	private Integer id;
	private String roleCode;
	private String rolePrivilegeCode;
	private String rolePrivilegeDescription;
	
	@Id
	@GeneratedValue (generator="role_privilege_id_inc")
	@SequenceGenerator(name="role_privilege_id_inc",sequenceName="ROLE_PRIVILEGE_ID_INC")	
	@Column(name="ID")	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	
	
	@Column(name="ROLE_CODE")
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode){
		this.roleCode = roleCode;
	}
	
	
	@Column(name="PRIVILEGE_DESC")
	public String getRolePrivilegeDescription() {
		return rolePrivilegeDescription;
	}
	public void setRolePrivilegeDescription(String roleprivilegeDescription) {
		this.rolePrivilegeDescription = roleprivilegeDescription;
	}
	
	@Column(name="PRIVILEGE_CODE")
	public String getRolePrivilegeCode() {
		return rolePrivilegeCode;
	}
	
	public void setRolePrivilegeCode(String rolePrivilegeCode) {
		this.rolePrivilegeCode = rolePrivilegeCode;
	}

}
