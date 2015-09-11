package com.service;

import java.util.List;

import com.model.Address;
import com.model.Customer;
import com.model.Store;


public interface HandleService {
	
	public boolean login(String fname,String password);
	public String customer();
	public void add(Customer cus);
	public void delete(short id);
	public void update(Customer cus);
	public List addressname();
	public Address address(String name);
	public Store store();

}
