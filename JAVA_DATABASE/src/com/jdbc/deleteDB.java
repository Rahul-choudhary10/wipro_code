package com.jdbc;
import java.sql.*;
public class deleteDB {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/wipro_training";
	static final String USERNAME = "root";
	static final String PASSWORD = "Rahul@123";
	
	public static void main(String args[]) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		
		int emp_id = 2;
		PreparedStatement ps = conn.prepareStatement("Delete from employee where emp_id = ?");
		ps.setInt(1, emp_id);
		
		int count = ps.executeUpdate();
		if(count>0)
			System.out.println("Delete sucessufully!");
		else
			System.out.println("Delete not sucessufully!");
		
		conn.close();
	}
}
