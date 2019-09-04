package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.item;
import com.util.db_con;

public class removeItemService {

	private static Connection con;
	private static PreparedStatement ps;
	
	public void removeItem(item i)
	{
		try {
		con = db_con.createConnection();
		ps = con.prepareStatement("delete from item where pid = ?");
		con.setAutoCommit(false);
		ps.setString(1 , i.getProductid());
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
