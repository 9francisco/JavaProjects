package com.opm.eis.service;

import java.util.List;

import com.opm.eis.model.Indicators;

public interface IndicatorsService {
	
	public List<Indicators> getIndicators(String smType, String strategyMetric);
	
	public void createIndicator(Indicators indicator);
	
	public void updateIndicator(Indicators indicator);
	
	public void deleteIndicator(Indicators indicator);

	public Indicators getIndicator(Integer id);
	
	public Indicators getIndicatorCode(String indicatorCode);

}
