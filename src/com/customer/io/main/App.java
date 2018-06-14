package com.customer.io.main;

import java.sql.SQLException;

import com.customer.io.core.Customer;

public class App {

	public static void main(String[] args) throws SQLException {
		new Visualizacao().resultado(new Customer());
	}
	
}

