package com.todo.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlUtil {
	private static Connection connection;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo","root","root");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
