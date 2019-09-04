package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.item;
import com.model.repair;
import com.util.db_con;

public class removeRepairService {

	private static Connection con;
	private static PreparedStatement ps;
	
	public void removeRepair(repair rep)
	{
		try {
		con = db_con.createConnection();
		ps = con.prepareStatement("delete from repair where itemId = ?");
		con.setAutoCommit(false);
		ps.setString(1 , rep.getItemId());
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
