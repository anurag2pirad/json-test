package com.roy.anurag;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimestampConverter {
	
	public static long convert(String timestamp) {
		
		String temp = timestamp;
	   	SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	    	
	   	if(temp.length() > 23) {
	       	if(temp.charAt(19) == '+' || temp.charAt(19) == '-') {
	       		temp = temp.substring(0, 19) + ".000" + temp.substring(19);
        	} else {
	       		temp = temp.substring(0, 23) + temp.substring(26);
	       	}
	       	parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
	       }
	   	parser.setTimeZone(TimeZone.getTimeZone("UTC"));
	   	
	   	Date date = null;
	    	
	    try {
	   		date = parser.parse(temp);
	   	} catch (ParseException e) {
	   		System.err.print("Failed to convert date from string for: " + timestamp);
	   	}
	    
	    return date.getTime();
	}
}
