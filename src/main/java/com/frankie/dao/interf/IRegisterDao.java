package com.frankie.dao.interf;

import java.util.List;

import com.controller.pojo.user.RegisterUserPojo;

public interface IRegisterDao {
	
	public void register(RegisterUserPojo rup);
	public List<RegisterUserPojo> loginUser(String mailid,String pwd);
	public int deleteUser(String mailid);
	public List<RegisterUserPojo> fetchdeleteUser();
}
