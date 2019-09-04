package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.user;
import com.util.db_con;

public class db_service {

	private static Connection con;
	private static PreparedStatement ps;
	
	public void addUser(user us)
	{
		try {
		con = db_con.createConnection();
		ps = con.prepareStatement("insert into user(email, uname, fname, lname, address, cno, password) values(? , ?, ?, ?, ?, ?, ? )");
		con.setAutoCommit(false);
		ps.setString(1 , us.getEmail());
		ps.setString(2 , us.getUname());
		ps.setString(3 , us.getFname());
		ps.setString(4 , us.getLname());
		ps.setString(5, us.getAddress());
		ps.setString(6 , us.getCno());
		ps.setString(7, us.getPassword());
		ps.execute();
		con.commit();
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			if(con != null)
				try {
					con.close();
				} catch (SQLException e) {
					
				}
		}
		
	}
	
}
