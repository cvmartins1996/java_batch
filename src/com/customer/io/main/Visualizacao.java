package com.customer.io.main;

import java.util.List;

import com.customer.io.core.Customer;
import com.customer.io.core.CustomerDto;

public class Visualizacao{
	
	public void resultado(Customer customer) {
		
		List<CustomerDto> ordenarCLientes = customer.ordenarCLientes();
		System.out.println("\"Clientes ordenados conforme o enunciado \" ");
		
		for (CustomerDto customerDto : ordenarCLientes) {
			System.out.println(" ID: " + customerDto.getId() + " Valor: " + customerDto.getValorTotal()  + " nome "  + customerDto.getNome());
		}
		
	}
	
}