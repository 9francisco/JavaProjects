package com.opm.eis.service;

import java.util.List;

import com.opm.eis.model.Indicators;
import com.opm.eis.dao.IndicatorsDao;

public class IndicatorsServiceImpl implements IndicatorsService {
	
	private IndicatorsDao indicatorDao;
	
	public Indicators getIndicatorCode(String indicatorCode) {
		
		return indicatorDao.findByIndicatorCode(indicatorCode);
	}
	
	@Override
	public List<Indicators> getIndicators(String smType, String strategyMetric){
		
		List<Indicators> ind = null;
		
		ind = indicatorDao.findAll(smType, strategyMetric);
		
		System.out.println(ind);
		return ind;
	}
	
	
	public void createIndicator(Indicators indicator){
		
		indicatorDao.create(indicator);
		
	}
	
	public void updateIndicator(Indicators indicator){
		
		indicatorDao.update(indicator);
		
	}
	
	@Override
	public void deleteIndicator(Indicators indicator){
		
		indicatorDao.delete(indicator);
		
	}

	@Override
	public Indicators getIndicator(Integer id){
		
		return indicatorDao.findById(id);
		
	}


	public IndicatorsDao getIndicatorDao() {
		return indicatorDao;
	}


	public void setIndicatorDao(IndicatorsDao indicatorDao) {
		this.indicatorDao = indicatorDao;
	}

}
