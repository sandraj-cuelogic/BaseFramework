package com.baseframework.automationFramework;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class CopyExecutionReportToReportsPath {
	
	static ObjectManager objManager = new ObjectManager();
	
	public static void copyReportToReportsPath(String reportName) throws IOException {
		File source = new File("..//BaseFramework//target//cucumber-reports//"+reportName);
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		File directory = new File((AutomationConfiguration.getConfigurationValueForProperty("ReportsFolder")+"//"+date.toString()+"//Reports"));
	    if (! directory.exists()){
        directory.mkdir();
    }
		File dest = new File(directory+"//"+date+"_"+reportName);
	    FileUtils.copyFile(source, dest);
	}
	
	public static void main(String[] args) throws IOException {
	
		copyReportToReportsPath("chrome_LucencyLogin_Report");
	}
}
