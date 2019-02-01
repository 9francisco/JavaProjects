package com.opm.eis.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opm.eis.model.Indicators;
import com.opm.eis.model.BalanceScorecards;
import com.opm.eis.model.CorporateThrusts;
import com.opm.eis.model.PerformanceAreas;
import com.opm.eis.model.Movement;

import com.opm.eis.service.IndicatorsService;
import com.opm.eis.service.StrategyMetricsBSCService;
import com.opm.eis.service.StrategyMetricsCTService;
import com.opm.eis.service.StrategyMetricsPAService;

import com.opensymphony.xwork2.ActionSupport;

public class IndicatorsAction extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;
	private Log logger = LogFactory.getLog(this.getClass());
	private IndicatorsService indicatorService;
	private StrategyMetricsBSCService strategyMetricBSCService;
	private StrategyMetricsCTService strategyMetricCTService;
	private StrategyMetricsPAService strategyMetricPAService;
	private Indicators indicator = new Indicators();
	
	private List<Indicators> indicators;
	private List<BalanceScorecards> listBSC;
	private List<CorporateThrusts> listCT;
	private List<PerformanceAreas> listPA;
	private List<Movement> listMovement;
	
	private String strategyMetric;
	private String smType;
	
	private Integer indicatorId;
	private String indicatorCode;
	private String indicatorDesc;
	private String movement;
	private String status;
	private String description;
	private String indicatorBalScoreCode;
	private String indicatorCorpThrustCode;
	private String indicatorPerfAreaCode;
	private Date startDate;
	private Date endDate;
	

	private Map<String,String> map = new HashMap<String,String>();
	
	
	
	public String save()
	{
		logger.debug("in save indicators");
		
		System.out.println("indicator code: " + getIndicatorCode() + getIndicatorId() + getIndicatorBalScoreCode());
		
		if(getIndicatorId() == 0)
		{
			setIndicatorId(null);
		}
		
		
		indicator.setId(getIndicatorId());
		indicator.setIndicatorCode(getIndicatorCode());
		indicator.setIndicatorDesc(getIndicatorDesc());
		indicator.setIndicatorBalScoreCode(getIndicatorBalScoreCode());
		indicator.setIndicatorCorpThrustCode(getIndicatorCorpThrustCode());
		indicator.setIndicatorPerfAreaCode(getIndicatorPerfAreaCode());
		indicator.setMovement(getMovement());
		indicator.setStatus(getStatus());
		indicator.setDescription(getDescription());
		indicator.setStartDate(getStartDate());
		indicator.setEndDate(getEndDate());
		
		//if(getIndicatorId() == 0)
		if (indicator.getId() == null)
		{
			System.out.println("indicator code: ");
			indicator.setStatus("A");
			indicator.setDeleted("1");
			indicatorService.createIndicator(indicator);
			addActionMessage("Indicator successfully created.");
		}
		else
		{
			indicator.setDeleted("1");
			indicatorService.updateIndicator(indicator);
			addActionMessage("Indicator successfully updated.");
		}
		
		getMap().put("view", "success-page");
		return SUCCESS;
	}
	
	
	public String list()
	{
		//indicators = indicatorService.getIndicators();
		
		return SUCCESS;
	}
	
	public String view()
	{
		System.out.println(getIndicatorCode());
		indicator = indicatorService.getIndicatorCode(getIndicatorCode());
		//indicators = indicatorService.getIndicators();	
	
		
		if(getSmType().equals("BSC"))
		{
			//list CT & PA drop down
			listCT = strategyMetricCTService.populateCT();
			listPA = strategyMetricPAService.populatePA();
			
			getMap().put("perfIndSM", "CT-PA");
		}
		else if (getSmType().equals("CT"))
		{
			//list BSC & PA drop down
			listBSC = strategyMetricBSCService.populateBSC();
			listPA = strategyMetricPAService.populatePA();
			
			getMap().put("perfIndSM", "BSC-PA");
		}
		else if (getSmType().equals("PA"))
		{
			//list BSC & CT drop down
			listBSC = strategyMetricBSCService.populateBSC();
			listCT = strategyMetricCTService.populateCT();
			
			getMap().put("perfIndSM", "BSC-CT");
		}		
		
		getMap().put("view", "view");	
		
		return SUCCESS;
	}
	
    public String populateIndicators()
    {
    	if (getStrategyMetric() != null && !getStrategyMetric().equals(""))
    	{
    		if (getSmType().equals("BSC"))
    		{
    			//list all indicators of that BSC
    		}
    		else if (getSmType().equals("CT"))
    		{
    			
    		}
    		else if (getSmType().equals("PA"))
    		{
    			
    		}
    	}
    	
    	return SUCCESS;
    }
    
	public String add()
	{
		if(getSmType().equals("BSC"))
		{
			//list CT & PA drop down
			listCT = strategyMetricCTService.populateCT();
			listPA = strategyMetricPAService.populatePA();
			
			getMap().put("perfIndSM", "CT-PA");
		}
		else if (getSmType().equals("CT"))
		{
			//list BSC & PA drop down
			listBSC = strategyMetricBSCService.populateBSC();
			listPA = strategyMetricPAService.populatePA();
			
			getMap().put("perfIndSM", "BSC-PA");
		}
		else if (getSmType().equals("PA"))
		{
			//list BSC & CT drop down
			listBSC = strategyMetricBSCService.populateBSC();
			listCT = strategyMetricCTService.populateCT();
			
			getMap().put("perfIndSM", "BSC-CT");
		}		
		
		getMap().put("view", "add");
		
		return SUCCESS;
	}
	
	public String edit()
	{
		//indicators = indicatorService.getIndicators(); //list
		getMap().put("view", "edit");
		
		return SUCCESS;
	}
	
	public String input()
	{
		if(indicator != null && indicator.getId() != null)
		{
		//	indicators = indicatorService.getIndicators(); //list
			indicator = indicatorService.getIndicator(indicator.getId());
			
			getMap().put("view", "edit");
		}
		
		return INPUT;	
	}
	
	public String delete()
	{
		logger.debug("in method delete");
		
		if(indicator != null && indicator.getId() != null)
		{
			logger.debug("Indicator ID is " + indicator.getId() );
		}
		
		indicatorService.deleteIndicator(indicator);
		addActionMessage("Indicator successfully deleted.");
        getMap().put("view", "success-page"); 
		
		return SUCCESS;
	}
	
	
	public void setMap(Map<String,String> map) {
		this.map = map;
	}
	public Map<String,String> getMap() {
		return map;
	}


	public IndicatorsService getIndicatorService() {
		return indicatorService;
	}


	public void setIndicatorService(IndicatorsService indicatorService) {
		this.indicatorService = indicatorService;
	}


	public Indicators getIndicator() {
		return indicator;
	}


	public void setIndicator(Indicators indicator) {
		this.indicator = indicator;
	}


	public List<Indicators> getIndicators() {
		return indicators;
	}


	public void setIndicators(List<Indicators> indicators) {
		this.indicators = indicators;
	}


	public void setStrategyMetric(String strategyMetric) {
		this.strategyMetric = strategyMetric;
	}


	public String getStrategyMetric() {
		return strategyMetric;
	}


	public void setSmType(String smType) {
		this.smType = smType;
	}


	public String getSmType() {
		return smType;
	}


	public void setIndicatorCode(String indicatorCode) {
		this.indicatorCode = indicatorCode;
	}


	public String getIndicatorCode() {
		return indicatorCode;
	}


	public void setStrategyMetricBSCService(StrategyMetricsBSCService strategyMetricBSCService) {
		this.strategyMetricBSCService = strategyMetricBSCService;
	}


	public StrategyMetricsBSCService getStrategyMetricBSCService() {
		return strategyMetricBSCService;
	}


	public void setStrategyMetricCTService(StrategyMetricsCTService strategyMetricCTService) {
		this.strategyMetricCTService = strategyMetricCTService;
	}


	public StrategyMetricsCTService getStrategyMetricCTService() {
		return strategyMetricCTService;
	}


	public void setStrategyMetricPAService(StrategyMetricsPAService strategyMetricPAService) {
		this.strategyMetricPAService = strategyMetricPAService;
	}


	public StrategyMetricsPAService getStrategyMetricPAService() {
		return strategyMetricPAService;
	}


	public void setListBSC(List<BalanceScorecards> listBSC) {
		this.listBSC = listBSC;
	}


	public List<BalanceScorecards> getListBSC() {
		return listBSC;
	}


	public void setListCT(List<CorporateThrusts> listCT) {
		this.listCT = listCT;
	}


	public List<CorporateThrusts> getListCT() {
		return listCT;
	}


	public void setListPA(List<PerformanceAreas> listPA) {
		this.listPA = listPA;
	}


	public List<PerformanceAreas> getListPA() {
		return listPA;
	}


	public void setIndicatorId(Integer indicatorId) {
		this.indicatorId = indicatorId;
	}


	public Integer getIndicatorId() {
		return indicatorId;
	}


	public void setMovement(String movement) {
		this.movement = movement;
	}


	public String getMovement() {
		return movement;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getIndicatorBalScoreCode() {
		return indicatorBalScoreCode;
	}


	public void setIndicatorBalScoreCode(String indicatorBalScoreCode) {
		this.indicatorBalScoreCode = indicatorBalScoreCode;
	}


	public String getIndicatorCorpThrustCode() {
		return indicatorCorpThrustCode;
	}


	public void setIndicatorCorpThrustCode(String indicatorCorpThrustCode) {
		this.indicatorCorpThrustCode = indicatorCorpThrustCode;
	}


	public String getIndicatorPerfAreaCode() {
		return indicatorPerfAreaCode;
	}


	public void setIndicatorPerfAreaCode(String indicatorPerfAreaCode) {
		this.indicatorPerfAreaCode = indicatorPerfAreaCode;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getIndicatorDesc() {
		return indicatorDesc;
	}


	public void setIndicatorDesc(String indicatorDesc) {
		this.indicatorDesc = indicatorDesc;
	}


	public void setListMovement(List<Movement> listMovement) {
		this.listMovement = listMovement;
	}


	public List<Movement> getListMovement() {
		return listMovement;
	}
	

}
