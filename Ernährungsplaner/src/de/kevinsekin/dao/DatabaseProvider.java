package de.kevinsekin.dao;

import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DatabaseProvider 
{
	public static DataSource getDatabaseHandle()
	{
		try
		{
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUser("extremo");
			dataSource.setPassword("ernährung");
			dataSource.setServerName("localhost");
			dataSource.setDatabaseName("ernährung");
			return dataSource;
		} catch(Exception e)
		{
			return null;
		}
	}
}
