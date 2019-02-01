package com.opm.eis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name="INDICATORS")
@NamedQuery(name="indicator.findByIndicatorCode", query="from Indicators where indicatorCode = :indicatorcode")
public class Indicators {
	
	private Integer id;
	private String indicatorCode;
	private String indicatorDesc;
	private String indicatorPerfAreaCode;
	private String indicatorBalScoreCode;
	private String indicatorCorpThrustCode;
	private String movement;
	private String status;
	private Date startDate;
	private Date endDate;
	private String deleted;
	private String description;
	

	@Id
	@GeneratedValue (generator="indicator_id_inc")
	@SequenceGenerator(name="indicator_id_inc",sequenceName="INDICATOR_ID_INC")	
	@Column(name="ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="INDICATOR_CODE")
	public String getIndicatorCode() {
		return indicatorCode;
	}
	
	public void setIndicatorCode(String indicatorCode) {
		this.indicatorCode = indicatorCode;
	}
	
	@Column(name="INDICATOR_DESC")
	public String getIndicatorDesc() {
		return indicatorDesc;
	}
	
	public void setIndicatorDesc(String indicatorDesc) {
		this.indicatorDesc = indicatorDesc;
	}
	
	@Column(name="PERF_AREA_CODE")
	public String getIndicatorPerfAreaCode() {
		return indicatorPerfAreaCode;
	}

	public void setIndicatorPerfAreaCode(String indicatorPerfAreaCode) {
		this.indicatorPerfAreaCode = indicatorPerfAreaCode;
	}

	@Column(name="BAL_SCORE_CODE")	
	public String getIndicatorBalScoreCode() {
		return indicatorBalScoreCode;
	}

	public void setIndicatorBalScoreCode(String indicatorBalScoreCode) {
		this.indicatorBalScoreCode = indicatorBalScoreCode;
	}

	@Column(name="CORP_THRUST_CODE")	
	public String getIndicatorCorpThrustCode() {
		return indicatorCorpThrustCode;
	}

	public void setIndicatorCorpThrustCode(String indicatorCorpThrustCode) {
		this.indicatorCorpThrustCode = indicatorCorpThrustCode;
	}

	@Column(name="MOVEMENT")	
	public String getMovement() {
		return movement;
	}

	public void setMovement(String movement) {
		this.movement = movement;
	}

	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name="DELETED")
	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	
}
