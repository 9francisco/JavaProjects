package com.ef.util;
/*
 * 		
 * 09/09/2018	Gerald Francisco 	Created class for common properties		LogFileParser Project	
 * 
 */
 
import java.util.ResourceBundle;
  
public class CommonProperties
{   
	static private CommonProperties _instance = null;
	
	static ResourceBundle resource=null;

	static {
		refreshResource();
	}
	
	public static void init() {
		try {
			resource =  ResourceBundle.getBundle("config");				
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

    public static ResourceBundle getResource()
    {
        return resource;
    }
    
	static public void refreshResource()
	{
		resource=null;
		_instance = null;
		init();
	}
	
    static public CommonProperties getInstance()
    {
        if (null == _instance)
        {
            _instance = new CommonProperties();
        }
        return _instance;
    }
    
	static public String getString(String key) {
		String value = "";
		if (resource!=null) {
			try {
				value = resource.getString(key);
			} catch (Exception e) {
				value="";
			}
		}
		return value.trim();
	}
}
