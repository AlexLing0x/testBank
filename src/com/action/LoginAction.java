package com.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.UserInfo;
import com.service.UserInfoService;

@Controller
public class LoginAction extends ActionSupport{

	private UserInfo userInfo;
	
	@Resource
	private UserInfoService userInfoService;
	
	/**
	 * ��¼
	 * @return
	 */
	public String login(){
		
		//ͨ�������Ķ���ȡrequest
		HttpServletRequest req = ServletActionContext.getRequest();
		
		if(userInfoService.login(userInfo)){//��¼�ɹ�
			
			HttpSession session = req.getSession();
			session.setAttribute("user", userInfo);
			//����Ȩ���ж�
			UserInfo userInfo1 = userInfoService.getUserInfo(userInfo.getUserId());
			session.setAttribute("user1", userInfo1);
			
			System.out.println(userInfo1.getAuthority());
			
			return "main";
		}
		//s 
		/*this.addActionMessage("�û������������");*/
		req.setAttribute("flag",1);
		return "login";
	}
	
	/**
	 * �˳���¼
	 * @return
	 */
	public String logOut(){
		HttpServletRequest req = ServletActionContext.getRequest();
		req.getSession().removeAttribute("user");
		return "login";
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}


	
	
	
	
}
