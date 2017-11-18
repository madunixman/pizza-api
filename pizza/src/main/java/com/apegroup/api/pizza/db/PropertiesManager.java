package com.apegroup.api.pizza.db;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesManager {
	static Logger log =  Logger.getLogger("PropertiesManager");
	
    private static PropertiesManager istanza;
    public static final String APPLICATION_CONFIGURATION_FILE =
            System.getProperty("user.home") + "/pizza.properties";
    private static Properties properties;

    private PropertiesManager()
    {
    	log.debug("PropertiesManager CONSTRUCTOR called");
        properties = new Properties();
        try
        {
            log.debug("Before loading file:"+ APPLICATION_CONFIGURATION_FILE);
            properties.load(new FileInputStream(APPLICATION_CONFIGURATION_FILE));
            log.debug("After loading file:"+ APPLICATION_CONFIGURATION_FILE);
        }
        catch (Exception e)
        {
            log.debug("Cannot load file: [" + APPLICATION_CONFIGURATION_FILE + "]");
            System.out.println("Cannot load file: [" + APPLICATION_CONFIGURATION_FILE + "]");
        }
    }

    public static PropertiesManager getInstance()
    {
        if (istanza == null)
        {
            istanza = new PropertiesManager();
        }
        return istanza;
    }

    public Properties getProperties() {
        return properties;
    }

}

