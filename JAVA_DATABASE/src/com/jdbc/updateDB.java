package com.jdbc;
import java.sql.*;
public class updateDB {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/wipro_training";
	static final String USERNAME = "root";
	static final String PASSWORD = "Rahul@123";
	
	public static void main(String args[]) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		int emp_id = 2;
		String emp_name = "Aryan";
		String emp_status = "Single";
		PreparedStatement ps = conn.prepareStatement("Update employee set emp_name = ?, emp_status = ? where emp_id = ?");
		
		ps.setString(1, emp_name);
		ps.setString(2, emp_status);
		ps.setInt(3, emp_id);
		
		int count = ps.executeUpdate();
		if(count>0) {
			System.out.println("Update sucessfully");
		}
		else {
			System.out.println("Update failed");
		}
		
		conn.close();
		
	}

}
