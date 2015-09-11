package com.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.HandleService;

public class GetAddressAction{
	public HandleService handleServiceImp;
	public List list;
	public HandleService getHandleServiceImp() {
		return handleServiceImp;
	}
	public void setHandleServiceImp(HandleService handleServiceImp) {
		this.handleServiceImp = handleServiceImp;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}

	public String getAddress(){
		list=handleServiceImp.addressname();
		return "success";
	}

	
}
