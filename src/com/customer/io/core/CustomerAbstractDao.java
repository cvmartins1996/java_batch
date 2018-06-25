package com.customer.io.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.List;

import com.customer.io.configuration.ClassName;
import com.customer.io.dao.Dao;

public class CustomerAbstractDao extends CustomerDao{

	@Override
	public List<CustomerDto> findAllCustomers(List<CustomerDto> customers) {
		try {
			List<String> fields = new ClassName().to(CustomerDto.class, 1l);
			
			for (String string : fields) {
				System.out.println("string " + string);
			}
			
			CustomerDto customerDto = null;
			Connection makeConnection;
			makeConnection = Dao.makeConnection();
			Statement ps = makeConnection.createStatement();
			
			StringBuilder qry = new StringBuilder();
			
			
			qry.append(" select id, cpf_cnpj, nm_customer, is_active, vl_total from tb_customer_account ");
			
			ResultSet rs = ps.executeQuery(qry.toString());
			
			while(rs.next()) {
				customerDto = new CustomerDto();
				customerDto.setId(rs.getLong("id"));
				customerDto.setCpfCnpj(rs.getString("cpf_cnpj"));
				customerDto.setNome(rs.getString("nm_customer"));
				customerDto.setAtivo(rs.getBoolean("is_active"));
				customerDto.setValorTotal(rs.getFloat("vl_total"));
				
				customers.add(customerDto);
			}
			
			rs.close();
			ps.close();
			makeConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public List<CustomerDto> findCustomersByValue(List<CustomerDto> customers) {
		customers.sort(Comparator.comparing(CustomerDto::getValorTotal).reversed());
		return customers;
	}

}