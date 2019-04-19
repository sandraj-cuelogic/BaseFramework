package com.Lucency.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AutomationConfiguration {

	    private Properties properties = new Properties();
	    private static AutomationConfiguration globalConfiguration = null;
	    // TODO: figure out how we can have a default config file for framework specified.
	    private final static String DEFAULT_CONFIG_PATH = "src/main/java/com/Lucency/Configurations/config.properties";

	    protected AutomationConfiguration()
	    {
	        // Load default configuration from framework specific location.
	    	
	        loadAllProperties(DEFAULT_CONFIG_PATH);
	    }

	    private void loadAllProperties(String configFilePath) 
	    {
	        properties = new Properties();
	        try 
	        {
	            properties.load(new FileInputStream(configFilePath));
	        }
	        catch (IOException e) 
	        {
	            throw new RuntimeException("Could not read the properties file");
	        }
	    }

	    public void setGlobalConfigurationFile(String configFile)
	    {
	        reloadAllProperties(configFile);
	    }

	    private void reloadAllProperties(String configFile)
	    {
	        loadAllProperties(configFile);
	    }

	    public static AutomationConfiguration globalConfiguration()
	    {
	        if (globalConfiguration == null)
	        {
	            globalConfiguration = new AutomationConfiguration();
	        }
	        return globalConfiguration;
	    }

	    private String readConfigurationProperty(String propertyName) 
	    {
	        String defaultValue = "";
	        return properties.getProperty(propertyName, defaultValue);
	    }

	    public static String getConfigurationValueForProperty(String propertyName)
	    {
	        return AutomationConfiguration.globalConfiguration().readConfigurationProperty(propertyName);
	    }
	}
