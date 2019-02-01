package com.opm.eis.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtils {
	

	public String getDateToday()
	{
	  Date date = Calendar.getInstance().getTime();
	  SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	  return sdf.format(date);
	}
	
	public String sendDate(){
		
		String dateToday = new String();
		dateToday = getDateToday().toString();
		return dateToday;
	}
	/*
	public Date changeDate(){

	  Date date = Calendar.getInstance().getTime();
	  SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	  Date dateString = sdf.format(date);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
	    Date convertedDate = dateFormat.parse(dateString);
	    return convertedDate;
	
	}
	*/
}
