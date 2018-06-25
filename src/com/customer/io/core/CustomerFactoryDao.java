package com.customer.io.core;

import java.util.ArrayList;
import java.util.List;

public class CustomerFactoryDao{
	
	private List<CustomerDto> customers = new ArrayList<>();
	
	public CustomerFactoryDao(CustomerDto customerDto) {
		
	}

	public static CustomerFactoryDao getInstance(CustomerDto customersDTO) {
		return new CustomerFactoryDao(customersDTO);
	}
	
	public CustomerDao getCustomer() {
		return new CustomerAbstractDao();
	}
	
	public List<CustomerDto> getAllCustomers() {
		CustomerDao customerDao = getCustomer();
		
		List<CustomerDto> findAllCustomers = customerDao.findAllCustomers(customers);
		
		return findAllCustomers;
	}
	
	public List<CustomerDto> getCustomersByValue(List<CustomerDto> verificaSeEstaAptoParacalcularMedia){
		CustomerDao customerDao = getCustomer();
		
		List<CustomerDto> findCustomersByValue = customerDao.findCustomersByValue(verificaSeEstaAptoParacalcularMedia);
		
		return findCustomersByValue;
	}
	
}