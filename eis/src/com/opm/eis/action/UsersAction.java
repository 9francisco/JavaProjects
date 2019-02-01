package com.opm.eis.action;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.opm.eis.model.Users;
import com.opm.eis.service.UsersService;

import com.opm.eis.model.Offices;
import com.opm.eis.service.OfficesService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

public class UsersAction extends ActionSupport implements SessionAware
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
	private Log logger = LogFactory.getLog(this.getClass());
	private UsersService userService ;
	private Users user;
	private List<Users> users;
	private List<Offices> officesDropdown;
	private OfficesService officeService;

	String oldpassword = null;
	String newpassword = null;
	String search_glevel = null;
	String search_officename = null;

	@SuppressWarnings("unchecked")
	private Map session;
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
    	
    	//String login = (String) user.getFirstName();
    	//System.out.println(login);
    	
        if (user.getId() == null)
        {
        	user.setPassword(user.getUserID());
        	user.setDeleted("1");
        	userService.createUser(user);
        	addActionMessage("User successfully added.");
        }
        else
        {
        	user.setDeleted("1");
        	userService.updateUser(user);
            addActionMessage("User successfully updated.");
        }
        
        getMap().put("view", "success-page");
        return SUCCESS;
    }

    /**
     * Handles actions involving authenticating 
     * user. Sets the logged-in session to true
     * @return success or error
     */
    public String authenticate()
    {
    	logger.debug("in method authenticate");

    	boolean loginStatus = userService.validateUser(user.getUserID(),user.getPassword());

    	if ( loginStatus == true)
        {
    		  user = userService.getUserID(user.getUserID());
    		  //user.setLastLoginDate();
    		  String loginName = (String) user.getFirstName()+" "+(String) user.getLastName();
    		     		  
    		  getSession().put("logged","true");
    		  getSession().put("userid",user.getUserID());
    		  getSession().put("loginName",loginName);
    	            
    		return SUCCESS;
        }
        else 
        {
        return ERROR;
        }
    }

	public String modifyPassword() {
    	
    	logger.debug("in method modifyPassword");
    	
    	oldpassword = getOldpassword();
    	newpassword = getNewpassword();
    	
    	String uname = getSession().get("userid").toString();
    	
    	user = userService.getUserID(uname);
    	
    	String existingpassword = (String) user.getPassword();
    	
    	if (oldpassword.equals(existingpassword)){
    		
    		boolean verified = userService.verifyPassword(user.getUserID(),newpassword,oldpassword);
    		
    		if (verified){
    			
    			addActionMessage("Password Successfully Changed.");
    			getMap().put("view", "success-page");
    			return SUCCESS;
    		} else {
    			addActionMessage("Error Changing Password.");
    			getMap().put("view", "success-page");
    			return ERROR;
    		}
    	
    	}
    	else {
    		addActionMessage("Old Passwords does not match.");
    		getMap().put("view", "success-page");
    		return ERROR;
    	}
    	
    }

    
    public String logout(){   	
    		
    	String uname = getSession().get("userid").toString();
		userService.logoutUser(uname);
		getSession().remove("logged");
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
        
	    	if (user != null && user.getId() != null)
	        {
	        	logger.debug("User ID is " + user.getId() );
	            
	        }
	    	
	    	userService.deleteUser(user);
	        addActionMessage("User successfully deleted.");
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
        users = userService.getUsers();
        
        return SUCCESS;
        
    }

    /**
     * Handles list all User objects action.
     * Sets users instance field to all
     * User objects.
     * @return
     */
    
    public String userdetails()
    {

    	user = userService.getUserID(user.getUserID());

        return SUCCESS;
        
    }    
    
    
    /**added by kaye**/
    public String view()
    {
    		
    	user = userService.getUserID(user.getUserID());
    	users = userService.getUsers();
    	officesDropdown = officeService.getOffices(search_glevel, search_officename); //get values for default office
    	
    	getMap().put("view", "view");
    	addActionMessage("Viewing current user.");
    	
    	
    	return SUCCESS;
        
    }    
    
    public String add()
    {
    	users = userService.getUsers(); //list
    	officesDropdown = officeService.getOffices(search_glevel, search_officename); //get values for default office
    	getMap().put("view", "add");
    	
    	return SUCCESS;
    }
    
    public String edit()
    {
    	user = userService.getUserID(user.getUserID());
    	users = userService.getUsers();
    	
    	getMap().put("view", "edit");
    	
    	return SUCCESS;
    }
    
    /**end - added by kaye**/
    
    @Override
    public String input()
    {
    	logger.debug("in method input");
    	
    	if (user != null && user.getId() != null)
        {
        	logger.debug("User ID is " + user.getId() );
            user = userService.getUser(user.getId());
            
            users = userService.getUsers(); //list
            officesDropdown = officeService.getOffices(search_glevel, search_officename); //get values for default office
            getMap().put("view", "edit");
            //System.out.println(user);
            
        }
        return INPUT;
    }

	public UsersService getUserService() {
		return userService;
	}

	public void setUserService(UsersService userService) {
		this.userService = userService;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	 public void setSession(Map session) {
		    this.session = session;
		  }
		  
	 public Map getSession() {
		    return session;
		  }

	public void setMap(Map<String,String> map) {
			this.map = map;
		}

	public Map<String,String> getMap() {
			return map;
		}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public void setOfficesDropdown(List<Offices> officesDropdown) {
		this.officesDropdown = officesDropdown;
	}

	public List<Offices> getOfficesDropdown() {
		return officesDropdown;
	}

	public void setOfficeService(OfficesService officeService) {
		this.officeService = officeService;
	}

	public OfficesService getOfficeService() {
		return officeService;
	}
    
}
