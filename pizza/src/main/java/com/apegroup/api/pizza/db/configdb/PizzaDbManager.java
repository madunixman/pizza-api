package com.apegroup.api.pizza.db.configdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.apegroup.api.pizza.db.PropertiesManager;
import net.lulli.metadao.DbConnectionManager;
import org.apache.log4j.Logger;

public class PizzaDbManager extends DbConnectionManager
{
    private static final Logger log =  Logger.getLogger("PizzaDbManager");
	private static PizzaDbManager instance;
	
	protected String JDBC_URL; 
	protected String DRIVER_CLASS_NAME; 
	protected String DB_USER; 
	protected String DB_PASSWORD;

	public  Connection getConnection()
    {
	    log.debug("CALLED getConnection() ");
		 Connection con = null;
		    try{
		    	log.debug("getConnection CALLED");
		     	Class.forName(DRIVER_CLASS_NAME);
			    con = DriverManager.getConnection(JDBC_URL);
		    }
		    catch (Exception e){
		    	e.printStackTrace();
		    	log.debug("retrieving driver: "+e);
		    }
		    return con;
	}

	public  void releaseConnection( Connection con)
    {
	    closeConnection(con);
	}
	
	public  void closeConnection( Connection con)
    {
    try{
    	if (null != con){
    		con.close();
    	} 
    }
    catch (Exception e){
      e.printStackTrace();
    }
}

	public static PizzaDbManager getInstance()
    {
		log.debug("getInstance CALLED");
	    return new PizzaDbManager();
	}
	
	protected PizzaDbManager()
    {
		log.debug("CassandraDbManager CALLED");
		PropertiesManager pmanager = PropertiesManager.getInstance();
		Properties p = pmanager.getProperties();
		JDBC_URL= p.getProperty("pizza.JDBC_URL");
		DRIVER_CLASS_NAME= p.getProperty("pizza.DRIVER_CLASS_NAME");
		DB_USER = p.getProperty("pizza.DB_USER");
		DB_PASSWORD = p.getProperty("pizza.DB_PASSWORD");
	}
}
