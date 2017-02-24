package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private Connection conn = null;
	public Connection getConnection() {
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/fj21", "root", "");
			
		} catch (SQLException e) {
		throw new RuntimeException(e);
		} 
		return conn;
	}
	public void setConnection(Connection conn){
		this.conn   = conn;
		
	}

}
