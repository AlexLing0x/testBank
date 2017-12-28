package com.service;

import java.util.List;

import com.pojo.UserInfo;

public interface UserInfoService {

	
	public boolean login(UserInfo userInfo);
	
	public List<UserInfo> getUserInfo(UserInfo userInfo);
	
	public void addUser(UserInfo userInfo);
	
	public void update(UserInfo userInfo);
	
	public void del(String userId);
	
   public UserInfo getUserInfo(String userId);
   
   public void modifyPw(UserInfo UserInfo);

    public int getOne(String userId);

	public int checkPwd(String uid, String oldPwd);



}
