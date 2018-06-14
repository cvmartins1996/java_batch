package com.customer.io.main;

import java.sql.SQLException;
import java.util.List;

import com.customer.io.core.Customer;
import com.customer.io.core.CustomerDto;

public class Visualizacao{
	
	public void resultado(Customer customer) throws SQLException {
		
		List<CustomerDto> ordenarCLientes = customer.ordenarCLientes();
		System.out.println("\"Clientes ordenados conforme o enunciado \" ");
		
		for (CustomerDto customerDto : ordenarCLientes) {
			System.out.println(" ID: " + customerDto.getId() + " Valor: " + customerDto.getValorTotal()  + " nome "  + customerDto.getNome());
		}
		
	}
	
}