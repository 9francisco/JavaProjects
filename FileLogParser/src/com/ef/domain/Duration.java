package com.ef.domain;
/*
 * 		
 * 09/09/2018	Gerald Francisco 	Created enum class for Duration		LogFileParser Project	
 * 
 */

public enum Duration {

    HOURLY("hourly"), DAILY("daily");

    private final String value;
    
    Duration(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }	
    
}