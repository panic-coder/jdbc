/**
 * Purpose: Handles all the utility methods
 * 
 * @author Kumar Shubham
 * @since 23/06/2018
 *
 */

package com.bridgeit.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bridgeit.model.Info;

public class Utility {
	Scanner scanner;
	Connection connection = null;
	Statement statement = null;
	
	public Utility(){
		scanner = new Scanner(System.in);
	}
	
	public String inputString() {
		try {
			return scanner.next();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public int inputInteger() {
		try {
			return scanner.nextInt();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void createDatabase(String databaseName) {
		try {
			connection = DataBaseConnection.getConnection("");
			statement = connection.createStatement();
			String query;
			query = "create database "+databaseName+";";
			statement.executeUpdate(query);
			System.out.println("Created");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void openExistingDatabase(String databaseName) {
		try {
			connection = DataBaseConnection.getConnection(databaseName);
			statement = connection.createStatement();
			String query;
			query = "show tables";
			statement.executeQuery(query);
			System.out.println("Opened");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void dropDatabase(String databaseName) {
		try {
			connection = DataBaseConnection.getConnection(databaseName);

			statement = connection.createStatement();
			String query;
			query = "drop database "+databaseName;
			statement.executeUpdate(query);
			System.out.println("droped");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void createTable(String tableNew, String databaseName) {
		try {
			connection = DataBaseConnection.getConnection(databaseName);
			statement = connection.createStatement();
			String query;
			query = "create table "+tableNew+"(id int not null,"
					+ "firstName varchar(50)not null,"
					+ "lastName varchar(50)not null,"
					+ "gender varchar(6)not null,"
					+ "maritalStatus varchar(10)not null,"
					+ "primary key(id)"
					+ ");";
			statement.executeUpdate(query);
			System.out.println("Table created");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateTables(String databaseName) {
		try {
			connection = DataBaseConnection.getConnection(databaseName);
			statement = connection.createStatement();
			String query;
			query = "show tables from "+databaseName;
			int t = statement.executeUpdate(query);
			System.out.println("Tables"+t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(Info info, String databaseName) {
		try {
			connection = DataBaseConnection.getConnection(databaseName);
			statement = connection.createStatement();
			String query;
			query = "insert into data values("+info+")";
			int t = statement.executeUpdate(query);
			System.out.println("Inserted "+t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(String databaseName) {
		try {
			connection = DataBaseConnection.getConnection(databaseName);
			statement = connection.createStatement();
			String query;
			query = "select * from data";
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				Info info = new Info();
				info.setId(result.getInt("id"));
				info.setFirstName(result.getString("firstName"));
				info.setLastName(result.getString("lastName"));
				info.setGender(result.getString("gender"));
				info.setMaritalStatus(result.getString("maritalStatus"));
				System.out.println(info);
			}
			int loopUpdate = 0;
			while(loopUpdate==0) {
			System.out.println("Enter the id to update");
			int id = inputInteger();
			System.out.println("1. Update first name\n"
					+ "2. Update last name\n"
					+ "3. Update marital status\n"
					+ "4. Close menu");
			int choiceUpdate = inputInteger();
			switch (choiceUpdate) {
			case 1:
				System.out.println("Enter the new first name to be updated");
				String firstName = inputString();
				query = "update data set firstName = '"+firstName+"' where id = "+id;
				break;
			case 2:
				System.out.println("Enter the name to be updated");
				String lastName = inputString();
				query = "update data set lastName = '"+lastName+"' where id = "+id;
				break;
			case 3:
				System.out.println("Enter the name to be updated");
				String status = inputString();
				query = "update data set maritalStatus = '"+status+"' where id = "+id;
				break;
			case 4:
				loopUpdate=1;
				System.out.println("Update menu closed");
				break;
			default:
				loopUpdate=1;
				System.out.println("Wrong choice");
				break;
			}
			}
			statement.executeUpdate(query);
			query = "select * from data";
			ResultSet result2 = statement.executeQuery(query);
			while(result2.next()) {
				Info info = new Info();
				info.setId(result2.getInt("id"));
				info.setFirstName(result2.getString("firstName"));
				info.setLastName(result2.getString("lastName"));
				info.setGender(result2.getString("gender"));
				info.setMaritalStatus(result2.getString("maritalStatus"));
				System.out.println(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void delete(String databaseName) {
		try {
			connection = DataBaseConnection.getConnection(databaseName);
			statement = connection.createStatement();
			String query;
			query = "select * from data";
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				Info info = new Info();
				info.setId(result.getInt("id"));
				info.setFirstName(result.getString("firstName"));
				info.setLastName(result.getString("lastName"));
				info.setGender(result.getString("gender"));
				info.setMaritalStatus(result.getString("maritalStatus"));
				System.out.println(info);
			}
			System.out.println("Enter the id you want to delete");
			int id = inputInteger();
			query = "delete from data where id = "+id;
			statement.executeUpdate(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void display(String databaseName) {
		try {
			connection = DataBaseConnection.getConnection(databaseName);
			statement = connection.createStatement();
			String query;
			query = "select * from data";
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				Info info = new Info();
				info.setId(result.getInt("id"));
				info.setFirstName(result.getString("firstName"));
				info.setLastName(result.getString("lastName"));
				info.setGender(result.getString("gender"));
				info.setMaritalStatus(result.getString("maritalStatus"));
				System.out.println(info);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
