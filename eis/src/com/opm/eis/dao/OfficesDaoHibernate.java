package com.opm.eis.dao;

import java.util.List;

import com.opm.eis.model.Offices;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("officeDao")
public class OfficesDaoHibernate extends HibernateDaoSupport implements OfficesDao {

	@Transactional
	public void create(Offices office) {
		
		getHibernateTemplate().saveOrUpdate(office);

	}

	@Transactional
	public void delete(Offices office) {

        //getHibernateTemplate().delete(office);
		System.out.println("deleting...");
		
		String deletedoffice = "UPDATE Offices SET DELETED='0' WHERE officeCode='"+ office.getOfficeCode()+"'";
		Query query = getSession().createQuery(deletedoffice);
		query.executeUpdate();		
		
		System.out.println("deleted...");

	}
	
	@SuppressWarnings("unchecked")
	//@Transactional(readOnly = true)
	public List<Offices> findAll(String search_glevel,String search_officename) {
				
		if (search_glevel == null && search_officename == null)
		{ return getHibernateTemplate().find("from Offices  where DELETED = '1' ORDER BY officeDesc");	}
		
		else if (search_glevel.equals("ALL") && search_officename.equals("-Select-"))
		{ return getHibernateTemplate().find("from Offices  where DELETED = '1'");	}

		else if (search_glevel.equals("ALL") && search_officename != null)
		{ return getHibernateTemplate().find("from Offices WHERE OFFICE_DESC = '"+search_officename+"' AND DELETED = '1' ORDER BY officeDesc");	}	
		
		else if (search_glevel == null && search_officename != null)
		{ return getHibernateTemplate().find("from Offices WHERE OFFICE_DESC = '"+search_officename+"' AND DELETED = '1' ORDER BY officeDesc");	}

		else if (search_glevel != null && search_officename == null)
		{ return getHibernateTemplate().find("from Offices where GLEVEL = '"+search_glevel+"' AND DELETED = '1' ORDER BY officeDesc"); }

		else if (search_glevel != null && search_officename.equals("-Select-"))
		{ return getHibernateTemplate().find("from Offices where GLEVEL = '"+search_glevel+"' AND DELETED = '1' ORDER BY officeDesc"); }		
		
		else  
		{ return getHibernateTemplate().find("from Offices where GLEVEL = '"+search_glevel+"' and OFFICE_DESC = '"+search_officename+"' AND DELETED = '1' ORDER BY officeDesc");	}
		
	}

	@Transactional
	public void update(Offices office) {
		
		System.out.println("Office Head Man No: " + office.getOfficeHeadManNo());
		
		getHibernateTemplate().saveOrUpdate(office);

	}

	@Transactional
	public Offices findByOfficeCode(String officeCode) {
		
		System.out.println("viewing... " + officeCode);
		
		
		Query query = getSession().getNamedQuery("office.findByOfficeCode");
		query.setString("officecode", officeCode);
		Offices office = (Offices) query.uniqueResult();
		return office;	
	
	}

	@Transactional
	public int deleteAll() {
		
		String hql = "delete Offices";
		Query query = getSession().createQuery(hql);
		int rowCount = query.executeUpdate();
		return rowCount;	
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<String> listofficename(String search_glevel) {
		
		List<String> officenames = null;
		
		if (!search_glevel.equals("ALL"))
		{
			String hql = "SELECT officeDesc from Offices WHERE GLEVEL = '"+search_glevel+"' AND DELETED = '1'";
			Query query = getSession().createQuery(hql);
			officenames = query.list();
		}
		else
		{
			String hql = "SELECT officeDesc from Offices  where DELETED = '1'";
			Query query = getSession().createQuery(hql);
			officenames = query.list();			
		}
		
		return officenames;
	}

}

