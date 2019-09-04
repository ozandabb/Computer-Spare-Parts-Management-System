package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.model.*;

import com.util.db_con;

public class managerServices {

	private static Connection con;
	private static PreparedStatement ps;
	
	private static String productid;
	private static String productName;
	private static String productType;
	private static int quantity;
	private static float price;
	private static String description;
	
	public static item it = new item();
	
	public static item getInventoryDetails() {
		
		try{
			//Class.forName("com.mysql.jdbc.Driver");
			con = db_con.createConnection();
			ps = con.prepareStatement("select * from item");
	
			ps.executeQuery();
			
			ResultSet rs = ps.getResultSet();

			while(rs.next()) {
				it.setProductid(rs.getString("pid"));
				it.setProductName(rs.getString("productName"));
				it.setProductType(rs.getString("productType"));
				it.setQuantity(rs.getInt("quantity"));
				it.setPrice(rs.getFloat("price"));
				it.setDescription(rs.getString("description"));
				/*
				productid = rs.getString("pid");
				productName = rs.getString("productName");
				productType = rs.getString("productType");
				quantity = rs.getInt("quantity");
				price = rs.getFloat("price");
				description = rs.getString("description");
				
				System.out.println(productid);
				System.out.println(productName);
				*/
				
				return it;
			}
			
	
		}catch(Exception e){
			System.out.println(e);
		}
		return it;
		
	}
	
}
