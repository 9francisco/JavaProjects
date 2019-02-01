package com.opm.eis.model;

//import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.persistence.Transient;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="ROLES")
@NamedQuery(name="role.findByRoleCode", query="from Roles where roleCode = :rolecode")
public class Roles {
	
	private Integer id;
	private String roleCode;
	private String roleDescription;
	private String deleted;
	
	@Id
	@GeneratedValue (generator="role_id_inc")
	@SequenceGenerator(name="role_id_inc",sequenceName="ROLE_ID_INC")	
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
	
	
	@Column(name="ROLE_DESC")
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription){
		this.roleDescription = roleDescription;
	}
	
	@Column(name="DELETED")
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}


}
