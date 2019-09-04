package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.repair;
import com.util.db_con;

public class updateRepairService {

	private static Connection con;
	private static PreparedStatement ps;
	
	public void updateRepair(repair r)
	{
		try {
		con = db_con.createConnection();
		ps = con.prepareStatement("update repair set status = ? where itemId = ?");
		con.setAutoCommit(false);
		ps.setString(1 , r.getStatus());
		ps.setString(2 , r.getItemId());
		
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
