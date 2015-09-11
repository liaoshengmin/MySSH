package com.action;

import java.util.List;

import com.model.Customer;
import com.service.HandleService;

public class ShowAction{
	public HandleService handleServiceImp;
	public String data;
	public HandleService getHandleServiceImp() {
		return handleServiceImp;
	}
	public void setHandleServiceImp(HandleService handleServiceImp) {
		this.handleServiceImp = handleServiceImp;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String show(){
		data =handleServiceImp.customer();
		return "success";
	}

}
