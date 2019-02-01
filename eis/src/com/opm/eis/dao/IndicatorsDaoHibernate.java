package com.opm.eis.dao;

import java.util.List;

import com.opm.eis.model.Indicators;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("indicatorDao")
public class IndicatorsDaoHibernate extends HibernateDaoSupport implements IndicatorsDao{
	
	@Transactional
	public void create (Indicators indicator){
		
		getHibernateTemplate().saveOrUpdate(indicator);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional (readOnly=true)
	public List<Indicators> findAll(String smType, String strategyMetric){
		
		List<Indicators> ind = null;
		
		if (smType.equals("BSC"))
		{
			System.out.println("in dao bsc. " + smType + " " + strategyMetric);
			
			/*String hql = "from Indicators WHERE BAL_SCORE_CODE = '"+strategyMetric+"' AND DELETED = '1'";
			Query query = getSession().createQuery(hql);
			
			return ind;
			*/
			return getHibernateTemplate().find("from Indicators where DELETED = '1' and indicatorBalScoreCode = '"+strategyMetric+"'");
		}
		else if (smType.equals("CT"))
		{
			return getHibernateTemplate().find("from Indicators where DELETED = '1' AND CORP_THRUST_CODE = '"+strategyMetric+"'");
		}
		else
		{
			return getHibernateTemplate().find("from Indicators where DELETED = '1' AND PERF_AREA_CODE = '"+strategyMetric+"'");
		}
		
		
	}

	@Transactional
	public Indicators findById(Integer id){
		
		return (Indicators) getHibernateTemplate().get(Indicators.class, id);
	}
	
	@Transactional
	public Indicators findByIndicatorCode(String indicatorCode){
		
		Query query = getSession().getNamedQuery("indicator.findByIndicatorCode");

		query.setString("indicatorcode", indicatorCode);
		
		Indicators indicator = (Indicators) query.uniqueResult();
		
		//System.out.print("Print userprivilegeCode: "+ userprivilegeCode);
		
		return indicator;			
	
	}
	
	@Transactional
	public void update (Indicators indicator){
		
		getHibernateTemplate().saveOrUpdate(indicator);
	}
	
	@Transactional
	public void delete (Indicators indicator){
		
		String deletedindicator = "UPDATE Indicators SET DELETED=0 WHERE ID='"+indicator.getId()+"'";
		Query query = getSession().createQuery(deletedindicator);
		query.executeUpdate();		

	}
	

}
