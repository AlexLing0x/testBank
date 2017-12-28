package com.mapper;

import java.util.List;

import com.pojo.UserInfo;

public interface UserInfoMapper {

	public Integer selCount(UserInfo userInfo);
	
	public List<UserInfo> selALL(UserInfo userInfo);
	
	public void add(UserInfo userInfo);
	
	public void update(UserInfo userInfo);
	
	public void del(String userId);
	
	public UserInfo selOne(String userId);
	
	public void modifyPw(UserInfo userInfo);

	public int getOne(String userId);

	public int checkPwd(String uid, String oldPwd);



	
	
}
