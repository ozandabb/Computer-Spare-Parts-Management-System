package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class db_con {

public static Connection createConnection() {
		
		Connection con = null;
		
		String url ="jdbc:mysql://localhost:3306/cspms";
		String username = "root";
		String password = "root";
		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		
			con = DriverManager.getConnection(url, username, password);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	
}
