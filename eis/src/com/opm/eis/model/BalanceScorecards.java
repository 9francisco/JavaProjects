package com.opm.eis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BALANCE_SCORECARDS")
@NamedQuery(name="bsc.findBSCbyCode", query="from BalanceScorecards where bscCode = :strategyMetricCode")
public class BalanceScorecards {
	
	private Integer bscID;
	private String bscCode;
	private String bscDesc;
	private String bscStatus;
	
	@Id
	@GeneratedValue (generator="bsc_id_inc")
	@SequenceGenerator(name="bsc_id_inc",sequenceName="BSC_ID_INC")	
	@Column(name="ID")
	public Integer getBscID() {
		return bscID;
	}
	public void setBscID(Integer bscID) {
		this.bscID = bscID;
	}
	
	@Column(name="BAL_SCORE_CODE")
	public String getBscCode() {
		return bscCode;
	}
	public void setBscCode(String bscCode) {
		this.bscCode = bscCode;
	}
	
	@Column(name="BAL_SCORE_DESC")
	public String getBscDesc() {
		return bscDesc;
	}
	public void setBscDesc(String bscDesc) {
		this.bscDesc = bscDesc;
	}
	
	@Column(name="STATUS")
	public String getBscStatus() {
		return bscStatus;
	}
	public void setBscStatus(String bscStatus) {
		this.bscStatus = bscStatus;
	}

}
