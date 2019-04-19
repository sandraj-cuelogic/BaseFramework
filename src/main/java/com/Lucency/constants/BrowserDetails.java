package com.Lucency.constants;

public class BrowserDetails {
	
	public static String browserName;
	public static String sessionID;
	
	public String getBrowserName(){
		
		return browserName;
	}
	
	public void setBrowserName(String browserNameString){
		this.browserName = browserNameString;
	}
	
	public String getDriverSessionID(){
		return sessionID;
	}
	
	public void setDriverSessionID(String sessionID){
		this.sessionID = sessionID;
	}


}
