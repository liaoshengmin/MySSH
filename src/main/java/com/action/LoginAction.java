package com.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.service.HandleService;

public class LoginAction{
	private String fname;
	private String password;
	public HandleService handleServiceImp;

	public String login(){
		boolean bool = handleServiceImp.login(fname,password);
		Map<String, String> session = (Map) ActionContext.getContext().getSession();
		if(bool){
			session.put("user", fname);
			return "success";

		}
		else{
			return "error";
		}
		
		
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HandleService getHandleServiceImp() {
		return handleServiceImp;
	}

	public void setHandleServiceImp(HandleService handleServiceImp) {
		this.handleServiceImp = handleServiceImp;
	}
	
	
	
	

}
