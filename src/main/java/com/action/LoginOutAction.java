package com.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class LoginOutAction {
	
	public String loginout(){
		Map session = ActionContext.getContext().getSession();
		session.put("user", null);
		return "error";
	}

}
