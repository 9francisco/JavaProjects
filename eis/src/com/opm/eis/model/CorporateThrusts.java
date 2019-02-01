package com.opm.eis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CORPORATE_THRUSTS")
@NamedQuery(name="ct.findCTbyCode", query="from CorporateThrusts where ctCode = :strategyMetricCode")
public class CorporateThrusts {
	
	private Integer ctID;
	private String ctCode;
	private String ctDesc;
	private String ctStatus;

	@Id
	@GeneratedValue (generator="ct_id_inc")
	@SequenceGenerator(name="ct_id_inc",sequenceName="CT_ID_INC")	
	@Column(name="ID")	
	public Integer getCtID() {
		return ctID;
	}
	public void setCtID(Integer ctID) {
		this.ctID = ctID;
	}

	@Column(name="CORP_THRUST_CODE")
	public String getCtCode() {
		return ctCode;
	}
	public void setCtCode(String ctCode) {
		this.ctCode = ctCode;
	}
	
	@Column(name="CORP_THRUST_DESC")
	public String getCtDesc() {
		return ctDesc;
	}
	public void setCtDesc(String ctDesc) {
		this.ctDesc = ctDesc;
	}
	
	@Column(name="STATUS")
	public String getCtStatus() {
		return ctStatus;
	}
	public void setCtStatus(String ctStatus) {
		this.ctStatus = ctStatus;
	}
}
