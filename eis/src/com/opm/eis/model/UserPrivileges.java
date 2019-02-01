package com.opm.eis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="USER_PRIVILEGES")
@NamedQuery(name="userprivilege.findByUserPrivilegeCode", query="from UserPrivileges where userprivilegeCode = :userprivilegecode")
public class UserPrivileges {
	
	private Integer id;
	private String userprivilegeCode;
	private String userprivilegeDesc;
	private String userprivilegeFunc;
	private String userprivilegeStatus;
	private String userprivilegeSubmodule;
	private String userprivilegeAppointable;
	private String deleted;
	
	@Id
	@GeneratedValue (generator="user_privilege_id_inc")
	@SequenceGenerator(name="user_privilege_id_inc",sequenceName="USER_PRIVILEGE_ID_INC")	
	@Column(name="ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="PRIVILEGE_CODE")
	public String getUserprivilegeCode() {
		return userprivilegeCode;
	}
	public void setUserprivilegeCode(String userprivilegeCode) {
		this.userprivilegeCode = userprivilegeCode;
	}
	
	@Column(name="PRIVILEGE_DESC")
	public String getUserprivilegeDesc() {
		return userprivilegeDesc;
	}
	public void setUserprivilegeDesc(String userprivilegeDesc) {
		this.userprivilegeDesc = userprivilegeDesc;
	}
	
	@Column(name="FUNCTION")
	public String getUserprivilegeFunc() {
		return userprivilegeFunc;
	}
	public void setUserprivilegeFunc(String userprivilegeFunc) {
		this.userprivilegeFunc = userprivilegeFunc;
	}
	
	@Column(name="STATUS")
	public String getUserprivilegeStatus() {
		return userprivilegeStatus;
	}
	public void setUserprivilegeStatus(String userprivilegeStatus) {
		this.userprivilegeStatus = userprivilegeStatus;
	}
	
	@Column(name="MODULE_CODE")
	public String getUserprivilegeSubmodule() {
		return userprivilegeSubmodule;
	}
	public void setUserprivilegeSubmodule(String userprivilegeSubmodule) {
		this.userprivilegeSubmodule = userprivilegeSubmodule;
	}

	@Column(name="APPOINTABLE")
	public String getUserprivilegeAppointable() {
		return userprivilegeAppointable;
	}
	public void setUserprivilegeAppointable(String userprivilegeAppointable) {
		this.userprivilegeAppointable = userprivilegeAppointable;
	}	
	
	@Column(name="DELETED")
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}	
	
}
