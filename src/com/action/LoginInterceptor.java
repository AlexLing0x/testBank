package com.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{

	public String intercept(ActionInvocation ai) throws Exception {
		// TODO Auto-generated method stub
		
		//如果访问是LoginAction,不做判断,继续访问
		if(ai.getAction() instanceof LoginAction){
			return ai.invoke();
		}
		
		
		//获取上下文
		ActionContext ac = ai.getInvocationContext();
		//获取Session,不是session对象，session对应的Map对象
		Map<String,Object> session = ac.getSession();
		if(session.get("user") != null){ //已经登录
			return ai.invoke();
		}
		
		//如果没有登录，跳转到登录页面
		return "login";
		
		
	}
	
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	

}
