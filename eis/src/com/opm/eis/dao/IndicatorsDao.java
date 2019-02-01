package com.opm.eis.dao;

import java.util.List;

import com.opm.eis.model.Indicators;

public interface IndicatorsDao {
	
	public void create (Indicators indicator);
	
	public List<Indicators> findAll(String smType, String strategyMetric);

	public Indicators findById(Integer id);
	
	public Indicators findByIndicatorCode(String indicatorCode);
	
	public void update (Indicators indicator);
	
	public void delete (Indicators indicator);

}
