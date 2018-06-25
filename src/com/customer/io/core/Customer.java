package com.customer.io.core;

import java.util.ArrayList;
import java.util.List;

public class Customer{
	private List<CustomerDto> customers = new ArrayList<>();
	
	public List<CustomerDto> getAllCustomers() {
		customers = new CustomerFactoryDao(new CustomerDto()).getAllCustomers();
		return customers;
	}
	
	public List<CustomerDto> verificaSeEstaAptoParacalcularMedia() {
		List<CustomerDto> customers = getAllCustomers();
		List<CustomerDto> customersFinal = new ArrayList<>();
		
		for (CustomerDto customerDto : customers) {
			if (customerDto.getValorTotal() > 560) {
				if (customerDto.getId() >= 1500 && customerDto.getId() <= 2700) {
					customersFinal.add(customerDto);
				}
			}
		}
		return customersFinal;
	}

	public float getMedia() {
		return somatoria(); 
	}

	private float somatoria() {
		float somatoria = 0;
		
		List<CustomerDto> customers = verificaSeEstaAptoParacalcularMedia();
		
		for (CustomerDto customerDto : customers) {
			somatoria = somatoria + customerDto.getValorTotal();
		}
		return (somatoria/customers.size());
		
	}
	
	
	public List<CustomerDto> ordenarCLientes() {
		List<CustomerDto> verificaSeEstaAptoParacalcularMedia = verificaSeEstaAptoParacalcularMedia();
		
		List<CustomerDto> customersByValue = new CustomerFactoryDao(new CustomerDto()).getCustomersByValue(verificaSeEstaAptoParacalcularMedia);
		
		return customersByValue;
	}
	
}