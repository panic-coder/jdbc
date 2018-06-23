/**
 * Purpose: Database connection
 * 
 * @author Kumar Shubham
 * @since 23/06/2018
 *
 */

package com.bridgeit.utility;

import java.sql.*;

public class DataBaseConnection { 
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String DATABASE_URL = "jdbc:mysql://localhost:3306/";
	static final String USER = "root";
	static final String PASSWORD = "root";
	public static Connection getConnection(String databaseName) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DATABASE_URL+databaseName, USER, PASSWORD);
		return connection;
	}
}
