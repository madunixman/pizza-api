package com.apegroup.api.pizza.db.configdb;

import net.lulli.metadao.MetaPersistenceManager;
import org.apache.log4j.Logger;

import net.lulli.metadao.DbConnectionManager;
import net.lulli.metadao.extension.cassandra.CassandraMetaPersistenceManager;
import net.lulli.metadao.model.SQLDialect;


public class PizzaPersistentManager extends MetaPersistenceManager {
	private static final Logger log =  Logger.getLogger("PizzaPersistentManager");

	@Override
	public DbConnectionManager getDbConnectionManager()
    {
		PizzaDbManager dbManager = null;
		this.setSQLDialect(SQLDialect.CASSANDRA);
		dbManager = PizzaDbManager.getInstance();
		return dbManager;
	}
}
