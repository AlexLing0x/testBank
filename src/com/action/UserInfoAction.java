package com.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Chapter;
import com.pojo.UserInfo;
import com.service.UserInfoService;


@Controller
public class UserInfoAction extends ActionSupport{
	
	private UserInfo userInfo;
	
	@Resource
	private UserInfoService userInfoService;
	
	//��ȡȫ������
	public String list(){
		
		List<UserInfo> list = userInfoService.getUserInfo(userInfo);
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("list", list);
		return "list";
	}
 
	//����û�
	public String add(){
		int flag = 0;
		flag = userInfoService.getOne(userInfo.getUserId());
		if(flag==0){
			userInfoService.addUser(userInfo);
			userInfo = new UserInfo();
			return list();
		}else{
			HttpServletRequest req = ServletActionContext.getRequest();
			req.setAttribute("flag", flag);
			return "add";
		}
	}
	
	//Ԥ�޸��û�
	public String preupdate(){
		
		userInfo = userInfoService.getUserInfo(userInfo.getUserId());

		return "update";
	}
	
	//�޸��û�
	public String update(){
		userInfoService.update(userInfo);
		userInfo = new UserInfo();
		return list();
	}
   //ɾ���û�
	public String del(){
		/*userInfo = userInfoService.getUserInfo(userInfo.getUserId());*/
		
		userInfoService.del(userInfo.getUserId());
		userInfo = new UserInfo();
		return list();
	}
	
	//Ԥ�޸�����
     public String preModifyPw(){
    	
		userInfo = userInfoService.getUserInfo(userInfo.getUserId());
		 
		return "modifypw";
	}
	
   //�޸�����
     public String modifyPw(){
    	 
    	HttpServletRequest req = ServletActionContext.getRequest();
    	
    	String uid = userInfo.getUserId();
    	String oldPwd = userInfo.getOldPwd();
    	int flag= userInfoService.checkPwd(uid,oldPwd);
    	if(!(flag==1)){
    		int newflag =5;
    		req.setAttribute("newflag", newflag);
			return "modifypw";
    	}else{
    		
			userInfoService.modifyPw(userInfo);
			int newflag =1;
    		req.setAttribute("newflag", newflag);
   		    return "welcom";
    	}
	  
	  
  }
	
	
	public UserInfo getUserInfo() {
		return userInfo;
	}


	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	
	
	
	

}
