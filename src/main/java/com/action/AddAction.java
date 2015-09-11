package com.action;

import java.sql.Timestamp;
import java.util.Date;

import com.model.Address;
import com.model.Customer;
import com.model.Store;
import com.opensymphony.xwork2.ActionSupport;
import com.service.HandleService;

public class AddAction{
	public HandleService handleServiceImp;
	private String fname;
	private String lname;
	private String email;
	private String addressname;
	Customer cus = new Customer();
	
	public String add(){
		cus.setFirstName(fname);
		cus.setLastName(lname);
		cus.setEmail(email);
		Address ads=handleServiceImp.address(addressname);
		cus.setAddress(ads);
		Store sto=handleServiceImp.store();
		cus.setStore(sto);
		cus.setCreateDate(new Timestamp(new Date().getTime()));
		cus.setActive(true);
		handleServiceImp.add(cus);
		return "success";
	}
	
	
	
	public HandleService getHandleServiceImp() {
		return handleServiceImp;
	}
	public void setHandleServiceImp(HandleService handleServiceImp) {
		this.handleServiceImp = handleServiceImp;
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
	
	
	

}
