package com.ef.dao;
/*
 * 		
 * 09/09/2018	Gerald Francisco 	Created CommonDAO class for SQL transactions		LogFileParser Project	
 * 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ef.util.DateUtil;

public class CommonDAO extends ConnectionDAO {
	private static Logger logger = Logger.getLogger(CommonDAO.class);
	
	public static void insertRequestData(String values, int lineNumber, Connection conn) throws Exception {
		PreparedStatement ps = null;
		String [] arr_values = values.split("\\|",-1);
		String strQuery;
		
        try {
            
        	if((arr_values != null) && (arr_values.length == 5)) {
        		String field1 = DateUtil.formatDate(arr_values[0]);	// date
                String field2 = arr_values[1];						// ip
                String field3 = arr_values[2]; 						// request
                String field4 = arr_values[3];						// status
                String field5 = arr_values[4];  					// agent
                strQuery = "INSERT INTO request_log_data (REQUEST_DATE, REQUEST_IP, REQUEST_INFO, REQUEST_STATUS, REQUEST_AGENT) "
                		+ "VALUES (?,?,?,?,?)";
                ps = conn.prepareStatement(strQuery);
                ps.setString(1, field1);
                ps.setString(2, field2);
                ps.setString(3, field3);
                ps.setInt(4, Integer.parseInt(field4));
                ps.setString(5, field5);
                ps.executeUpdate();
            } else {
                logger.info(" Access File Log format should be: Date | IP | Request | Status | User Agent");
            }
        } catch (Exception e) {
            logger.error("Error in inserting request log data: " + e.toString());
            throw new Exception("Error in inserting request log data: " + e.toString());
        } finally {
        	if (ps !=null) {
        		ps.close();
        	}
        }
    }
	
	public static void insertBlockedData(Date startDate, String ip, String count, String duration, int threshold, Connection conn) throws Exception {
		PreparedStatement ps = null;
		String strQuery;
        try {        	
        	String comment = "This IP made more than " + threshold + " requests starting from "
							+ DateUtil.getFormattedDate(startDate) + " to " + DateUtil.getFormattedDate(DateUtil.getEndDate(startDate, duration))
							+ ". Record(s) found: " + count;
            strQuery = "INSERT INTO blocked_log_data (BLOCKED_IP, BLOCKED_REQ_COUNT, BLOCKED_COMMENT, BLOCKED_DATE) "
            		+ "VALUES (?,?,?,?)";
            ps = conn.prepareStatement(strQuery);
            ps.setString(1, ip);
            ps.setInt(2, Integer.parseInt(count));
            ps.setString(3, comment);
            ps.setString(4, DateUtil.getDefaultDate());
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("Error in inserting blocked log data: " + e.toString());
            throw new Exception("Error in inserting blocked log data: " + e.toString());
        } finally {
        	if (ps !=null) {
        		ps.close();
        	}
        }
    }
	
	public static List<Map<String, String>> getBlockedData(Date startTime, Date endTime, int threshold, Connection conn) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Map<String, String>> blockedData = new ArrayList<Map<String, String>>();

		String strQuery;
		
        try {        	
            strQuery = "SELECT REQUEST_IP, COUNT(*) as COUNT FROM request_log_data "
            		+ "WHERE REQUEST_DATE BETWEEN '" + DateUtil.getFormattedDate(startTime) + "' AND '"
            		+ DateUtil.getFormattedDate(endTime) + "' GROUP BY REQUEST_IP having COUNT > " + threshold + ";";;
            ps = conn.prepareStatement(strQuery);
	        rs = ps.executeQuery(strQuery);

	        while (rs.next()) {
	        	HashMap<String, String> hsTemp = new HashMap<String, String>();
                hsTemp.put("ip", rs.getString("REQUEST_IP"));
                hsTemp.put("count", rs.getString("COUNT"));
                blockedData.add(hsTemp);
	        }
        } catch (Exception e) {
            logger.error("Error in getting blocked log data: " + e.toString());
            throw new Exception("Error in getting blocked log data: " + e.toString());
        } finally {
        	if (rs !=null) {
        		rs.close();
        	}
        	if (ps !=null) {
        		ps.close();
        	}
        }
        
        return blockedData;
    }
	
	public static void deletedRequestData(Connection conn) throws Exception {
		PreparedStatement ps = null;
		String strQuery = "";
		try {
			conn = getConnection();
	    	strQuery = "DELETE FROM request_log_data";
	    	ps = conn.prepareStatement(strQuery);
	    	ps.execute();
	    } catch (Exception e) {
	        logger.error("Error in deleting request log data: " + e.toString());
            throw new Exception("Error in deleting request log data: " + e.toString());
    	} finally {
        	if (ps !=null) {
        		ps.close();
        	}
        }
	}
}