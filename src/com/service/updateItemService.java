package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.item;
import com.util.db_con;

public class updateItemService {

	private static Connection con;
	private static PreparedStatement ps;
	
	public void updateItem(item i)
	{
		try {
		con = db_con.createConnection();
		ps = con.prepareStatement("update item set productName = ?, productType = ?, quantity = ?, price = ?, description = ? where pid = ?");
		con.setAutoCommit(false);
		ps.setString(1 , i.getProductName());
		ps.setString(2 , i.getProductType());
		ps.setInt(3 , i.getQuantity());
		ps.setFloat(4 , i.getPrice());
		ps.setString(5 , i.getDescription());
		ps.setString(6, i.getProductid());
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
