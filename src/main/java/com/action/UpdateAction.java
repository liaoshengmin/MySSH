package com.action;

import com.model.Customer;
import com.service.HandleService;

public class UpdateAction {
	public HandleService handleServiceImp;
	private short customerId;
	private String fname;
	private String lname;
	private String email;
	private String addressname;
	
	public HandleService getHandleServiceImp() {
		return handleServiceImp;
	}
	public void setHandleServiceImp(HandleService handleServiceImp) {
		this.handleServiceImp = handleServiceImp;
	}
	public short getCustomerId() {
		return customerId;
	}
	public void setCustomerId(short customerId) {
		this.customerId = customerId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddressname() {
		return addressname;
	}
	public void setAddressname(String addressname) {
		this.addressname = addressname;
	}
	
	
	public String update(){
		Customer cus = new Customer();
		cus.setCustomerId(customerId);
		cus.setFirstName(fname);
		cus.setLastName(lname);
		cus.setEmail(email);
		cus.setAddress(handleServiceImp.address(addressname));
		handleServiceImp.update(cus);
		return "success";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

}
