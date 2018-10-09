package com.ef.dao;
/*
 * 		
 * 09/09/2018	Gerald Francisco 	Created class for MySQL Database Connection		LogFileParser Project	
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

import com.ef.util.CommonProperties;

public class ConnectionDAO {
	private static Logger logger = Logger.getLogger(ConnectionDAO.class);

	protected static Connection conn = null;
	

	static {
		try {
			initDriver();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		Connection con = null;

        try {            
            con = DriverManager.getConnection(CommonProperties.getString("db.DBURL"), 
                                              CommonProperties.getString("db.DBUSERNAME"),
                                              CommonProperties.getString("db.DBPASSWORD"));
        } catch (Exception e) {
        	logger.error("Error in getting connection"); 
        	logger.error(e.getMessage()); 
        	throw new Exception("Error in getting connection encountered.");
        }
        
    	return con;
    }

	static void initDriver() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

}