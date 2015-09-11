package com.service.imp;

import java.util.List;

import com.dao.HandleDao;
import com.model.Address;
import com.model.Customer;
import com.model.Store;
import com.service.HandleService;

public class HandleServiceImp implements HandleService {
	public HandleDao handleDaoImp;
	public HandleDao getHandleDaoImp() {
		return handleDaoImp;
	}
	public void setHandleDaoImp(HandleDao handleDaoImp) {
		this.handleDaoImp = handleDaoImp;
	}

	public boolean login(String fname, String password) {
		return handleDaoImp.login(fname, password);
	}

	public String customer() {
		return handleDaoImp.customer();
	}

	public List addressname() {
		return handleDaoImp.addressname();
	}

	public Address address(String name) {
		return handleDaoImp.address(name);
	}
	public Store store() {
		return handleDaoImp.store();
	}
	public void add(Customer cus) {
		handleDaoImp.add(cus);
		
	}
	public void delete(short id) {
		handleDaoImp.delete(id);
		
	}
	public void update(Customer cus) {
		handleDaoImp.update(cus);
		
	}
	
	

}
