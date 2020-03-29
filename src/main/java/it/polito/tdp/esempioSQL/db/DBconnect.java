package it.polito.tdp.esempioSQL.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBconnect {

	public static Connection getConnection() throws SQLException{
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=bdairam";
		
			return DriverManager.getConnection(jdbcURL);
		
	}
	

}
