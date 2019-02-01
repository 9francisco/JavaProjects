package com.opm.eis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PERFORMANCE_AREAS")
@NamedQuery(name="perfArea.findPAbyCode", query="from PerformanceAreas where perfAreaCode = :strategyMetricCode")
public class PerformanceAreas {
	
	private Integer perfAreaID;
	private String perfAreaCode;
	private String perfAreaDesc;
	private String perfAreaStatus;

	@Id
	@GeneratedValue (generator="perf_id_inc")
	@SequenceGenerator(name="perf_id_inc",sequenceName="PERF_ID_INC")	
	@Column(name="ID")	
	public Integer getPerfAreaID() {
		return perfAreaID;
	}
	public void setPerfAreaID(Integer perfAreaID) {
		this.perfAreaID = perfAreaID;
	}
	
	@Column(name="PERF_AREA_CODE")
	public String getPerfAreaCode() {
		return perfAreaCode;
	}
	public void setPerfAreaCode(String perfAreaCode) {
		this.perfAreaCode = perfAreaCode;
	}
	
	@Column(name="PERF_AREA_DESC")
	public String getPerfAreaDesc() {
		return perfAreaDesc;
	}
	public void setPerfAreaDesc(String perfAreaDesc) {
		this.perfAreaDesc = perfAreaDesc;
	}
	
	@Column(name="STATUS")
	public String getPerfAreaStatus() {
		return perfAreaStatus;
	}
	public void setPerfAreaStatus(String perfAreaStatus) {
		this.perfAreaStatus = perfAreaStatus;
	}
	
}
