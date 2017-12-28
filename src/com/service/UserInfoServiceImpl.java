package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mapper.UserInfoMapper;
import com.pojo.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService{


	@Autowired
	private UserInfoMapper userInfoMapper;
	
	public boolean login(UserInfo userInfo){
		boolean flag = false;
		int num = this.userInfoMapper.selCount(userInfo);
		if(num>0) flag = true;
		return flag;
	}

	@Override
	public List<UserInfo> getUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.selALL(userInfo);
	}

	@Override
	public void addUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userInfoMapper.add(userInfo);
		
	}

	@Override
	public void update(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userInfoMapper.update(userInfo);
		
	}

	@Override
	public void del(String userId) {
		// TODO Auto-generated method stub
		userInfoMapper.del(userId);
		
		
	}

	@Override
	public UserInfo getUserInfo(String userId) {
		// TODO Auto-generated method stub
		return userInfoMapper.selOne(userId);
	}

	@Override
	public void modifyPw(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userInfoMapper.modifyPw(userInfo);
	}

	@Override
	public int getOne(String userId) {
		// TODO Auto-generated method stub
		return userInfoMapper.getOne(userId);
	}

	@Override
	public int checkPwd(String uid, String oldPwd) {
		// TODO Auto-generated method stub
		return userInfoMapper.checkPwd(uid,oldPwd);
	}



	
	
	
	
	
}
