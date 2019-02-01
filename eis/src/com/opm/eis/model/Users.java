package com.opm.eis.model;

//import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="USERS")
@NamedQuery(name="user.findByUserID", query="from Users where userID = :userid")
/*@NamedQuery(name="user.validateUser", query="from Users where userID = :userid and password = :password")*/
public class Users {
	
	private Integer id;
	private String userID;
    //private String roleCode;
    private String lastName;
    private String middleInitial;
    private String firstName;

    private String contactNo;
    private String email;
    private String email2;

    private String officeCode;
    private String password;
	private String encryptedPassword;
	
	private Boolean status;
	private Date lastLoginDate;
	private Date lastPasswordChange;
	private String deleted;
	//private Calendar registrationDate;

	@Id
	@GeneratedValue (generator="id_inc")
	@SequenceGenerator(name="id_inc",sequenceName="ID_INC")	
	@Column(name="ID")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="USERID")
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	/*
	@Column(name="ROLE_CODE")
	public String getRoleCode() {
		return roleCode;
	}
	
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	*/
	
	@Column(name="LAST_NAME")
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="MIDDLE_INITIAL")
	public String getMiddleInitial() {
		return middleInitial;
	}
	
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	
	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="CONTACT_NO")
	public String getContactNo() {
		return contactNo;
	}
	
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="EMAIL2")
	public String getEmail2() {
		return email2;
	}
	
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	
	@Column(name="OFFICE_CODE")
	public String getOfficeCode() {
		return officeCode;
	}
	
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	
	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Transient
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	
	@Basic
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="LAST_LOGIN_DATE")
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="LAST_PWD_CHANGE")
	public Date getLastPasswordChange() {
		return lastPasswordChange;
	}
	
	public void setLastPasswordChange(Date lastPasswordChange) {
		this.lastPasswordChange = lastPasswordChange;
	}
	
	
	@Column(name="DELETED")
	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
	/*
	public Calendar getRegistrationDate() {
		return registrationDate;
	}
	
	public void setRegistrationDate(Calendar registrationDate) {
		this.registrationDate = registrationDate;
	}
	*/

}
