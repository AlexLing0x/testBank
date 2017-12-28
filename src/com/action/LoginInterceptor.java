package com.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{

	public String intercept(ActionInvocation ai) throws Exception {
		// TODO Auto-generated method stub
		
		//���������LoginAction,�����ж�,��������
		if(ai.getAction() instanceof LoginAction){
			return ai.invoke();
		}
		
		
		//��ȡ������
		ActionContext ac = ai.getInvocationContext();
		//��ȡSession,����session����session��Ӧ��Map����
		Map<String,Object> session = ac.getSession();
		if(session.get("user") != null){ //�Ѿ���¼
			return ai.invoke();
		}
		
		//���û�е�¼����ת����¼ҳ��
		return "login";
		
		
	}
	
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	

}
