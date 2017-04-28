package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	public static Connection getConnection() {
        Connection connection=null;
		try {
			Class.forName("org.sqlite.JDBC");
			 connection = DriverManager.getConnection("jdbc:sqlite:anwesenheit.db3");    
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}   
		return connection;
	       
		
	}

}
