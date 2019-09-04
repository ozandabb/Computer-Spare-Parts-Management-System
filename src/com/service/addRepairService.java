package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.item;
import com.model.repair;
import com.util.db_con;

public class addRepairService {

	private static Connection con;
	private static PreparedStatement ps;
	
	public void repair(repair r)
	{
		try {
		con = db_con.createConnection();
		ps = con.prepareStatement("insert into repair(name, address, contactNumber, date, itemId, description, ptype, amount) values(? , ?, ?, ?, ?, ?, ?, ? )");
		con.setAutoCommit(false);
		ps.setString(1 , r.getName());
		ps.setString(2 , r.getAddress());
		ps.setString(3 , r.getContactNumber());
		ps.setString(4 , r.getDate());
		ps.setString(5, r.getItemId());
		ps.setString(6 , r.getDescription());
		ps.setString(7 , r.getPtype());
		ps.setFloat(8, r.getAmount());
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
