package com.opm.eis.action;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opm.eis.model.Offices;
import com.opm.eis.service.OfficesService;
import com.opm.eis.model.Users;
import com.opm.eis.service.UsersService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

public class OfficesAction extends ActionSupport
{
    private static final long serialVersionUID = 1L;
	private Log logger = LogFactory.getLog(this.getClass());
	private OfficesService officeService ;
	private Offices office;
	private List<Offices> offices;
	private List<Offices> officesDropdown;
	private List<String> officenames = null;
	private String search_glevel; 
	private String search_officename;
	private UsersService userService;
	private List<Users> systemUsers;
	private String assignedOfficeHead;
	private Users assignedOfficeHeadName;
	
	private Map<String,String> map = new HashMap<String,String>();
	
	/**
     * Handles actions involving saving 
     * a new or changed User object.
     * Creates or updates user instance
     * field.
     * @return success
     */
    public String save()
    {
    	logger.debug("in method save");
   	
        if (office.getId() == null)
        {       	
        	office.setDeleted("1");
        	officeService.createOffice(office);
        	
        	addActionMessage("Office successfully created.");
        }
        else
        {
        	officeService.updateOffice(office);
        	
        	addActionMessage("Office successfully updated.");
        }
        
        getMap().put("view", "success-page");
        return SUCCESS;
    }

   
    /**
     * Handles delete User action.
     * Deletes user instance field.
     * @return success
     */
    public String delete()
    {
    	logger.debug("in method delete");
        
    	if (office != null && office.getOfficeCode() != null)
        {
        	logger.debug("Office Code is " + office.getOfficeCode() );
        	officeService.deleteOffice(office);
        	
        	addActionMessage("Office successfully deleted.");
            
        }

    	getMap().put("view", "success-page");
        return SUCCESS;
    }

    /**
     * Handles list all User objects action.
     * Sets users instance field to all
     * User objects.
     * @return
     */
   
    
    public String list()
    {    	
    	offices = officeService.getOffices(search_glevel,search_officename);
    	
        return SUCCESS;
    }
    
    public String populate()
    {

    	if (getSearch_glevel() != null && !getSearch_glevel().equals("")) {
    		
    		officenames = officeService.populateDetail(search_glevel);
        	
        	Collections.sort(officenames);
        	
    		return SUCCESS;
    		
    	} else {
    		
    	return SUCCESS;
    	
    	}
    	
    }

    @Override
    public String input()
    {
    	logger.debug("in method input");
    	
    	if (office != null && office.getOfficeCode() != null)
        {
        	logger.debug("Office Code is " + office.getOfficeCode());
            office = officeService.getOfficeCode(office.getOfficeCode());
        	setSystemUsers(userService.getUsers()); //get values for office head
        	officesDropdown = officeService.getOffices(search_glevel,search_officename); //get values for PCT

            setAssignedOfficeHead(office.getOfficeHeadManNo());
        	
            System.out.println("assigned: " + getAssignedOfficeHead() + "head");
            
            offices = officeService.getOffices(search_glevel,search_officename); //list
            
            getMap().put("view", "edit");
        }
        return INPUT;
    }
    
    
    public String view()
    {
    	System.out.println("view office details" + search_glevel + " name: " + search_officename);
    	
    	offices = officeService.getOffices(search_glevel,search_officename); //list
    	office = officeService.getOfficeCode(office.getOfficeCode());
    	
    	System.out.println("office name: " + office.getOfficeDesc());
    	
    	setSystemUsers(userService.getUsers()); //get values for office head
    	officesDropdown = officeService.getOffices(search_glevel,search_officename); //get values for PCT
    	
    	//assignedOfficeHeadName = userService.getUserID(office.getOfficeHeadManNo());
    	
    	//System.out.println(assignedOfficeHeadName.getFirstName());
    	
    	getMap().put("view", "view");
    	
    	return SUCCESS;
    }
    
    
    
    public String add()
    {
    	offices = officeService.getOffices(search_glevel,search_officename); //list
    	setSystemUsers(userService.getUsers()); //get values for office head
    	officesDropdown = officeService.getOffices(search_glevel,search_officename); //get values for PCT
    	
    	getMap().put("view", "add");
    	
    	return SUCCESS;
    }
    
    
    

	public OfficesService getOfficeService() {
		return officeService;
	}

	public void setOfficeService(OfficesService officeService) {
		this.officeService = officeService;
	}

	public Offices getOffice() {
		return office;
	}

	public void setOffice(Offices office) {
		this.office = office;
	}

	public List<Offices> getOffices() {
		return offices;
	}

	public void setOffices(List<Offices> offices) {
		this.offices = offices;
	}
	
    public String getSearch_glevel() {
		return search_glevel;
	}

	public void setSearch_glevel(String search_glevel) {
		this.search_glevel = search_glevel;
	}
	
	public String getSearch_officename() {
		return search_officename;
	}

	public void setSearch_officename(String search_officename) {
		this.search_officename = search_officename;
	}

	public List<String> getOfficenames() {
		return officenames;
	}


	public void setOfficenames(List<String> officenames) {
		this.officenames = officenames;
	}


	public void setMap(Map<String,String> map) {
		this.map = map;
	}


	public Map<String,String> getMap() {
		return map;
	}



	public void setUserService(UsersService userService) {
		this.userService = userService;
	}


	public UsersService getUserService() {
		return userService;
	}


	public void setSystemUsers(List<Users> systemUsers) {
		this.systemUsers = systemUsers;
	}


	public List<Users> getSystemUsers() {
		return systemUsers;
	}


	public void setAssignedOfficeHead(String assignedOfficeHead) {
		this.assignedOfficeHead = assignedOfficeHead;
	}


	public String getAssignedOfficeHead() {
		return assignedOfficeHead;
	}


	public void setAssignedOfficeHeadName(Users assignedOfficeHeadName) {
		this.assignedOfficeHeadName = assignedOfficeHeadName;
	}


	public Users getAssignedOfficeHeadName() {
		return assignedOfficeHeadName;
	}


	public void setOfficesDropdown(List<Offices> officesDropdown) {
		this.officesDropdown = officesDropdown;
	}


	public List<Offices> getOfficesDropdown() {
		return officesDropdown;
	}
	
}
