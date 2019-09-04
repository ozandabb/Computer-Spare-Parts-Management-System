package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.db_con;

public class loginService {

	private static Connection con;
	private static PreparedStatement ps;

	public boolean validate(String name,String pass){
		boolean status=false;
			
		try{
			//Class.forName("com.mysql.jdbc.Driver");
			con = db_con.createConnection();
			ps = con.prepareStatement("select * from user where uname=? and password=?");
			
			ps.setString(1,name);
			ps.setString(2,pass);
	
			ResultSet rs=ps.executeQuery();
			status = rs.next();
	
	
		}catch(Exception e){
			System.out.println(e);
		}
			return status;
	}
	
	
	public boolean adminValidate(String uname , String pass) {
		
		//boolean status;
		
		if(uname == "admin" && pass == "admin123") {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean managerValidate(String uname , String pass) {
		
		//boolean status;
		
		if(uname == "manager" && pass == "manager123") {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean employeeValidate(String uname , String pass) {
	
	//boolean status;
	
	if(uname == "employee" && pass == "employee123") {
		return true;
	}
	else {
		return false;
	}
}
}