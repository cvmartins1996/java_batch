package com.customer.io.core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Customer{
	private List<CustomerDto> customers = new ArrayList<>();
	
	public List<CustomerDto> getAllCustomers() throws SQLException{
		customers = new CustomerFactoryDao(new CustomerDto()).getAllCustomers();
		return customers;
	}
	
	public List<CustomerDto> verificaSeEstaAptoParacalcularMedia() throws SQLException {
		List<CustomerDto> customers = getAllCustomers();
		List<CustomerDto> customersFinal = new ArrayList<>();
		
		for (CustomerDto customerDto : customers) {
			if (customerDto.getValorTotal() > 5) {
				if (customerDto.getId() >= 1 && customerDto.getId() <= 20) {
					customersFinal.add(customerDto);
				}
			}
		}
		return customersFinal;
	}

	public float getMedia() throws SQLException {
		return somatoria(); 
	}

	private float somatoria() throws SQLException {
		float somatoria = 0;
		
		List<CustomerDto> customers = verificaSeEstaAptoParacalcularMedia();
		
		for (CustomerDto customerDto : customers) {
			somatoria = somatoria + customerDto.getValorTotal();
		}
		return (somatoria/customers.size());
		
	}
	
	
	public List<CustomerDto> ordenarCLientes() throws SQLException {
		List<CustomerDto> verificaSeEstaAptoParacalcularMedia = verificaSeEstaAptoParacalcularMedia();
		
		List<CustomerDto> customersByValue = new CustomerFactoryDao(new CustomerDto()).getCustomersByValue(verificaSeEstaAptoParacalcularMedia);
		
		return customersByValue;
	}
	
}