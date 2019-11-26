package com.frankie.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.log4j.Logger;

import com.controller.pojo.user.RegisterUserPojo;
import com.frankie.dao.interf.IRegisterDao;
import com.frankie.daoimpl.RegisterHibernateDaoImpl;

public class RegisterJdbcDaoImpl implements IRegisterDao {

	final static Logger logger=Logger.getLogger(RegisterJdbcDaoImpl.class);
	public void register(RegisterUserPojo rup) {
		System.out.println("executing RegisterJdbcDaoImp :: register ");
		logger.info("executing RegisterJdbcDaoImp :: register ");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hibproject","root","Root@123");
	    PreparedStatement ps= cn.prepareStatement("insert into user (mailid,name,mobile,password,city) values(?,?,?,?,?)");
	    ps.setString(1, rup.getMailid());
	    ps.setString(2, rup.getName());
	    ps.setString(3, rup.getMobile());
	    ps.setString(4, rup.getPassword());
	    ps.setString(5, rup.getCity());
	    ps.executeUpdate();
	    cn.close();
		} catch (Exception e) {
			logger.error("exception occured",e);
		}
		System.out.println("exit RegisterJdbcDaoImp :: register");
		logger.info("exit RegisterJdbcDaoImp :: register");
	}

	public List<RegisterUserPojo> loginUser(String mailid, String pwd) {
		System.out.println("executing RegisterJdbcDaoImp :: loginUser");
		logger.info("executing RegisterJdbcDaoImp :: loginUser");
		System.out.println("In Progress!!");
		System.out.println("executing RegisterJdbcDaoImp ::  loginUser");
		logger.info("executing RegisterJdbcDaoImp :: loginUser");
		return null;
	}

	public int deleteUser(String mailid) {
		System.out.println("executing RegisterJdbcDaoImp :: deleteUser");
		System.out.println("TODO");
		System.out.println("executing RegisterJdbcDaoImp :: deleteUser");
		return 0;
	}

	public List<RegisterUserPojo> fetchdeleteUser() {
		System.out.println("executing RegisterJdbcDaoImp :: fetchdeleteUser");
		System.out.println("TODO");
		System.out.println("executing RegisterJdbcDaoImp :: fetchdeleteUser");
		return null;
	}

}
