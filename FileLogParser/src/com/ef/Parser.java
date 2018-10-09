package com.ef;
/*
 * 		
 * 09/09/2018	Gerald Francisco 	Created Parser class which parses web server access log file, 		LogFileParser Project	
 * 									loads the log to MySQL and checks if a given IP makes more than 
 * 									a certain number of requests for the given duration
 * 
 */

import java.io.File;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.ef.dao.CommonDAO;
import com.ef.dao.ConnectionDAO;
import com.ef.domain.Duration;
import com.ef.util.CommonProperties;
import com.ef.util.DateUtil;
import com.ef.util.FileIOUtil;


public class Parser extends CommonDAO {
	private static Logger logger = Logger.getLogger(Parser.class);
	
	private static final String START_DATE = "--startDate";
	private static final String DURATION = "--duration";
	private static final String THRESHOLD = "--threshold";
	private static final String ACCESS_LOG = "--accesslog";
		
	public static void process(String startDate, String duration, int threshold, String accessLog) throws Exception {
		logger.debug("Processing web server access log file started...");
		System.out.println("Processing web server access log file started...");
		 
		FileIOUtil util = new FileIOUtil();
		Connection conn = null;
		Vector<String> v = util.getContentList(new File(accessLog));	
		String values = "";
		int lineNumber = 0;
		int totalRecords = 0;
		long startTime = System.currentTimeMillis();
		 
		try {
			 if (conn==null) {
				 conn = ConnectionDAO.getConnection();
				 conn.setAutoCommit(false);
			 }
		   
			 deletedRequestData(conn);
			 if (v != null && v.size() > 0) {
				 for (int i = 1; i < v.size(); i++) {
					 lineNumber++;
					 values = String.valueOf(v.get(i));

					 if (values != null && !values.equals("")) {
						 insertRequestData(values, lineNumber, conn);
					 }
					 totalRecords++;
					 
					 if (lineNumber == 5000) {
						 conn.commit();
						 lineNumber = 0;
						 logger.info("500 Committed/Total Inserted: " + totalRecords);
					 }
				 }
				 conn.commit();
				
				 Date sdfStartDate = DateUtil.parseDate(startDate);						 
				 Date sdfEndDate = DateUtil.getEndDate(sdfStartDate, duration);
			     
				 List<Map<String, String>> blockedData = getBlockedData(sdfStartDate, sdfEndDate, threshold, conn);
				 if (blockedData != null && !blockedData.isEmpty()) {
					 System.out.println("Given the following inputs: [Start Date: " + startDate +
							 ", Duration: " + duration + ", Threshold: " + threshold +"]." +
					 		 "\nBelow IPs have been blocked:");
					 for(Map<String, String> map: blockedData) {
						 String ip = map.get("ip");
						 String count = map.get("count");
						 insertBlockedData(sdfStartDate, ip, count, duration, threshold, conn);
						 System.out.println(ip + "\t[request count: " + count + "]");
					 }
					 conn.commit();
				 } else {
					 System.out.println("There is no IPs have been blocked.");
					 logger.debug("There is no IPs have been blocked.");	
				 }				 
			 } else {		
				 System.out.println("There is no file to parse.");	
				 logger.debug("There is no file to parse.");				
			 }		
		   
		} catch (SQLException e) {
			 logger.error("Log File Parser Error: " + e.getMessage().toString());
			 conn.rollback();
			 throw new Exception("Log File Parser Error encountered.");
		} finally {        
			 if (conn != null) {
				 conn.close();
			 }
		} 
		
		long endTime = System.currentTimeMillis();
        long elapsedTime = (endTime - startTime)/1000; //in seconds
        logger.debug("Processing web server access log file completed. Time elapsed: " + elapsedTime + " seconds");
		System.out.println("Processing web server access log file completed. Time elapsed: " + elapsedTime + " seconds");
	}
	
	
	protected static Map<String, String> convertArgumentsToMap(String[] args) {
		return Arrays.asList(args).parallelStream().map(arg -> arg.split("=")).collect(Collectors.toMap(arg -> arg[0], arg -> arg[1]));
	}
	
	public static void main(String args[]) throws Exception {
		Map<String, String> map = null;
		String startDate;
		String duration;
		int threshold;
		String accessLog;
		String path = "";

		try {
			map = convertArgumentsToMap(args);
			startDate = map.getOrDefault(START_DATE, "");
			duration = Duration.valueOf(map.getOrDefault(DURATION, "hourly").toUpperCase()).getValue();
			threshold = Integer.parseInt(map.getOrDefault(THRESHOLD, "0"));
			path = map.getOrDefault(ACCESS_LOG, CommonProperties.getString("folder.access.log"));
			accessLog = Paths.get(path.concat("/access.log")).toString();
			
			process(startDate, duration, threshold, accessLog);
		} catch (Exception e) {
			logger.error("\nInvalid arguments: " + map +
					"\nstartDate must be in yyyy-MM-dd.HH:mm:ss format, duration can take only hourly, daily as inputs and threshold must be an integer no less than 0. ");
			throw new Exception("\nInvalid arguments: " + map +
					"\nstartDate must be in yyyy-MM-dd.HH:mm:ss format, duration can take only hourly, daily as inputs and threshold must be an integer no less than 0. ");
		}
   }
}

