package com.opm.eis.service;

import java.util.List;

import com.opm.eis.dao.OfficesDao;
import com.opm.eis.model.Offices;

public class OfficesServiceImpl implements OfficesService {
	
	private OfficesDao officeDao;
	

	public Offices getOfficeCode(String officeCode) {
		
		return officeDao.findByOfficeCode(officeCode);
		
	}

	
	public List<Offices> getOffices(String search_glevel,String search_officename) {

		return officeDao.findAll(search_glevel,search_officename);
		
	}
	
	
	public void createOffice(Offices office) {
		
		officeDao.create(office);
		
	}
	
	
	public void deleteOffice(Offices office) {
		
		officeDao.delete(office);
		
	}
	
	
	public int deleteAllOffices() {
		
		return officeDao.deleteAll();
		
	}
	
	
	public void updateOffice(Offices office) {
		
		officeDao.update(office);
		
	}
	
	public List<String> populateDetail(String search_glevel) {
		
		return officeDao.listofficename(search_glevel);
	}
	
	
	public OfficesDao getOfficeDao() {
		return officeDao;
	}

	public void setOfficeDao(OfficesDao officeDao) {
		this.officeDao = officeDao;
	}
}
