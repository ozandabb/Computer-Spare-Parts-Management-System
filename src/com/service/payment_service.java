package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.payment;
import com.model.user;
import com.util.db_con;

public class payment_service {

	private static Connection con;
	private static PreparedStatement ps;
	
	public void addPayment(payment pay)
	{
		try {
		con = db_con.createConnection();
		ps = con.prepareStatement("insert into payment(cardName, cardNumber, month, year, cvc, email, contactNumber) values(? , ?, ?, ?, ?, ?, ?)");
		con.setAutoCommit(false);
		ps.setString(1, pay.getCardName());
		ps.setString(2, pay.getCardNumber());
		ps.setString(3, pay.getMonth());
		ps.setString(4, pay.getYear());
		ps.setString(5, pay.getCvc());
		ps.setString(6, pay.getEmail());
		ps.setString(7, pay.getContactNumber());
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
