package com.Interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map session = ActionContext.getContext().getSession();
		String user = (String) session.get("user");
		
		if(user!=null){
			String result = invocation.invoke();
			return result;
		}
		else{
			return Action.ERROR;
		}

	}

}
