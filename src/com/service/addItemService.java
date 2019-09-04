package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.item;
import com.util.db_con;

public class addItemService {

	private static Connection con;
	private static PreparedStatement ps;
	
	public void item(item i)
	{
		try {
		con = db_con.createConnection();
		ps = con.prepareStatement("insert into item(pid, productName, productType, quantity, price, description) values(? , ?, ?, ?, ?, ? )");
		con.setAutoCommit(false);
		ps.setString(1 , i.getProductid());
		ps.setString(2 , i.getProductName());
		ps.setString(3 , i.getProductType());
		ps.setInt(4 , i.getQuantity());
		ps.setFloat(5, i.getPrice());
		ps.setString(6 , i.getDescription());
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
