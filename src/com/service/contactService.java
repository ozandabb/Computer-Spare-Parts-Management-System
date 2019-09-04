package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.contact;
import com.util.db_con;


public class contactService {

	private static Connection con;
	private static PreparedStatement ps;
	
	public void contact(contact co)
	{
		try {
		con = db_con.createConnection();
		ps = con.prepareStatement("insert into contact(name, emai, subject, message) values(? , ?, ?, ?)");
		con.setAutoCommit(false);
		ps.setString(1, co.getName());
		ps.setString(2, co.getEmail());
		ps.setString(3, co.getSubject());
		ps.setString(4, co.getMessage());
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
