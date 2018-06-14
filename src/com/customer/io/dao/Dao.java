package com.customer.io.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

	public static Connection makeConnection() throws SQLException {
		try {
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/estudo", "root", "" );
			return con;
			
		} catch (SQLException e) {
			throw new SQLException(e);
		}
	}
}
