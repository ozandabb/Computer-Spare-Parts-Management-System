package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.item;
import com.model.user;
import com.util.db_con;

public class updateStockService {

	private static Connection con;
	private static PreparedStatement ps;
	private String message;
	
	public void stockUpdate(item i)
	{
		try {
		con = db_con.createConnection();
		ps = con.prepareStatement("update item set quantity = quantity + ? where pid = ?");
		con.setAutoCommit(false);
		ps.setInt(1, i.getQuantity());
		ps.setString(2 , i.getProductid());
		boolean st = ps.execute();
		
		if(st == true) {
			message = "<script>alert('Stock update sucessfull.')</script>";
		}
		else {
			message = "<script>alert('Stock update unsucessfull.')</script>";
		}
			
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
	
	public String getMessage() {
		return message;
	}
	
}
