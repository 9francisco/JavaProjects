package com.opm.eis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="STANDARD_INDICATORS")
public class StandardIndicators {
	
	private Integer id;
	private String userID;
	private String perfDate;
	private String indicatorCode;
	private String indicatorPerfAreaCode;
	private String indicatorBalScoreCode;
	private String indicatorCorpThrustCode;
	private Integer targetGoal;
	private Integer stretchGoal;
	private Integer weight;
	private String movement;
	private String status;
	private Date creationDate;
	private Date modifDate;

	@Column(name="ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="USER_ID")
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	@Column(name="PERF_YEAR")
	public String getPerfDate() {
		return perfDate;
	}
	
	public void setPerfDate(String perfDate) {
		this.perfDate = perfDate;
	}
	
	@Column(name="INDICATOR_CODE")
	public String getIndicatorCode() {
		return indicatorCode;
	}
	
	public void setIndicatorCode(String indicatorCode) {
		this.indicatorCode = indicatorCode;
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
	
	@Column(name="TARGET_GOAL")
	public Integer getTargetGoal() {
		return targetGoal;
	}
	
	public void setTargetGoal(Integer targetGoal) {
		this.targetGoal = targetGoal;
	}
	
	@Column(name="STRETCH_GOAL")
	public Integer getStretchGoal() {
		return stretchGoal;
	}
	
	public void setStretchGoal(Integer stretchGoal) {
		this.stretchGoal = stretchGoal;
	}
	
	@Column(name="WEIGHT")
	public Integer getWeight() {
		return weight;
	}
	
	public void setWeight(Integer weight) {
		this.weight = weight;
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
	@Column(name="CREATION_DATE")
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="MODIF_DATE")
	public Date getModifDate() {
		return modifDate;
	}
	
	public void setModifDate(Date modifDate) {
		this.modifDate = modifDate;
	}
}
