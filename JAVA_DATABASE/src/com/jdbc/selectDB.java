package com.jdbc;
import java.sql.*;
public class selectDB {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/wipro_training";
	static final String USERNAME = "root";
	static final String PASSWORD = "Rahul@123";
	
	public static void main(String args[]) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		
		
		PreparedStatement ps = conn.prepareStatement("Select * from employee");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("emp_id");
			String emp_name = rs.getString("emp_name");
			String emp_status = rs.getString("emp_status");
			System.out.print(id+" "+ emp_name+" "+ emp_status);
		}
		
		conn.close();
	}
}
