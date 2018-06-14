package com.customer.io.core;

import java.sql.SQLException;
import java.util.List;

public abstract class CustomerDao{
	public abstract List<CustomerDto> findAllCustomers(List<CustomerDto> customers) throws SQLException;
	public abstract List<CustomerDto> findCustomersByValue(List<CustomerDto> customers);
}