package com.opm.eis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="OFFICES")
@NamedQuery(name="office.findByOfficeCode", query="from Offices where officeCode = :officecode")
public class Offices {
	
	private Integer id;
	private String officeCode;
	private String officeDesc;
	private Integer officeVersion;
	private String officeHierarchy;
	private String officeType;
	private String officeMnemonic;
	private String officeHeadManNo;

	private String officeGLevel;
	private String pctOffice;	
	private String awardsCategory;
	
	private Date effDateStart;
	private Date effDateEnd;
	
	private String status;
	private String deleted;


	
	@Id
	@GeneratedValue (generator="office_id_inc")
	@SequenceGenerator(name="office_id_inc",sequenceName="OFFICE_ID_INC")	
	@Column(name="ID")
    public Integer getId() {
        return id;
    }
	 
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="OFFICE_CODE")
	public String getOfficeCode() {
		return officeCode;
	}
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
		
	@Column(name="OFFICE_DESC")
	public String getOfficeDesc() {
		return officeDesc;
	}
	public void setOfficeDesc(String officeDesc) {
		this.officeDesc = officeDesc;
	}

	@Column (name="VERSION")
	public Integer getOfficeVersion() {
		return officeVersion;
	}	
	public void setOfficeVersion(Integer officeVersion) {
		this.officeVersion = officeVersion;
	}	
	
	@Column(name="HIERARCHY")
	public String getOfficeHierarchy() {
		return officeHierarchy;
	}
	public void setOfficeHierarchy(String officeHierarchy) {
		this.officeHierarchy = officeHierarchy;
	}
	
	@Column(name="TYPE")
	public String getOfficeType() {
		return officeType;
	}
	public void setOfficeType(String officeType) {
		this.officeType = officeType;
	}
	
	@Column(name="MNEMONIC")
	public String getOfficeMnemonic() {
		return officeMnemonic;
	}
	public void setOfficeMnemonic(String officeMnemonic) {
		this.officeMnemonic = officeMnemonic;
	}
	
	@Column(name="HEAD_MANNO")
	public String getOfficeHeadManNo() {
		return officeHeadManNo;
	}
	public void setOfficeHeadManNo(String officeHeadManNo) {
		this.officeHeadManNo = officeHeadManNo;
	}
	
	@Column(name="GLEVEL")
	public String getOfficeGLevel() {
		return officeGLevel;
	}
	public void setOfficeGLevel(String officeGLevel) {
		
		this.officeGLevel = officeGLevel;
	}
	
	@Column(name="PCT_OFFICE")
	public String getPctOffice() {
		return pctOffice;
	}
	public void setPctOffice(String pctOffice) {
		this.pctOffice = pctOffice;
	}
	
	@Column(name="AWARDS_CATEGORY")
	public String getAwardsCategory() {
		return awardsCategory;
	}
	public void setAwardsCategory(String awardsCategory) {
		this.awardsCategory = awardsCategory;
	}

	@Column (name="EFF_DATE_START")
	public Date getEffDateStart() {
		return effDateStart;
	}
	public void setEffDateStart(Date effDateStart) {
		this.effDateStart = effDateStart;
	}

	@Column (name="EFF_DATE_END")
	public Date getEffDateEnd() {
		return effDateEnd;
	}
	public void setEffDateEnd(Date effDateEnd) {
		this.effDateEnd = effDateEnd;
	}

	@Column (name="STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Column (name="DELETED")
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}





}
