package com.ef.util;
/*
 * 		
 * 09/09/2018	Gerald Francisco 	Created DateUtil class		LogFileParser Project	
 * 
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.log4j.Logger;

public final class DateUtil {
	private static Logger logger = Logger.getLogger(DateUtil.class);
	
	private static String DEFAULT_DATE_FORMAT="yyyy-MM-dd.HH:mm:ss";
    private static TimeZone local = TimeZone.getDefault();
	
    public static Date parseDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        Date parsedDate;
        try {
            parsedDate = dateFormat.parse(date);
        } catch(ParseException e) {
            logger.error(e.getMessage()); 
            parsedDate = null;
        }
        return parsedDate;
    }
    
    public static String getFormattedDate(Date date) {
    	String dateString = "";
    	try {
	        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
	        dateString = sdf.format(date);
    	} catch (Exception e) {
	        logger.error(e.getMessage()); 
        }
    	return dateString;
    }
    
    public static String formatDate(String strDate) throws Exception {
    	String dateString = "";
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");
            Date date = sdf1.parse(strDate);
            dateString = sdf2.format(date).toString();
        } catch (Exception e) {
	        logger.error(e.getMessage()); 
        }
        return dateString;
    }
    
    public static String getDefaultDate() {
    	String dateString = "";
    	try {
	    	SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
	        local = TimeZone.getDefault();
	        sdf.setTimeZone(local);
	        dateString = sdf.format(new Date());
    	} catch (Exception e) {
	        logger.error(e.getMessage()); 
        }
        return dateString;
    }
        
    public static Date getEndDate(Date startDate, String duration) {
    	Calendar calendar = Calendar.getInstance();
        Date endDate = null;
        try {
        	calendar.setTime(startDate);
        	if (duration.equalsIgnoreCase("hourly")) {
        		calendar.add(Calendar.HOUR, 1);
            } else if (duration.equalsIgnoreCase("daily")) {
            	calendar.add(Calendar.DATE, 1);
            }
        	
        	endDate = calendar.getTime();
        } catch(Exception e) {
	        logger.error(e.getMessage()); 
	    }
        
        return endDate;
     }

 }