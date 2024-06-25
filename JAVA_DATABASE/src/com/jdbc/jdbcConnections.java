package com.jdbc;
import java.sql.*;
import java.util.Scanner;
public class jdbcConnections {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/wipro_training";
	static final String USERNAME = "root";
	static final String PASSWORD = "Rahul@123";

	public static void main(String args[])throws Exception  { 
//		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		
//		PreparedStatement preparedStatement =  connection.prepareStatement("Insert into employee values (1,'Rahul', 'Single' )");
		int emp_id = 2;
		String emp_name = "Mukesh";
		String emp_status = "Mingle";
		PreparedStatement preparedStatement =  connection.prepareStatement("Insert into employee values (?,?,?)");
		preparedStatement.setInt(1, emp_id);
		preparedStatement.setString(2, emp_name);
		preparedStatement.setString(3, emp_status);
		
		int count = preparedStatement.executeUpdate();
		
		if(count>0) {
			System.out.println("Data is inserted in database");
		}
		else {
			System.out.println("Fail...");
		}
		
		connection.close();
	}

}
