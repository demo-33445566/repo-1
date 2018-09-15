package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Application {

	public static void main(String[] args) throws Exception {
		
		Class.forName("org.h2.Driver");
		Connection connection = DriverManager.getConnection("jdbc:h2:~/h2.db;MODE=ORACLE;AUTO_SERVER=true", "sa","");
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery("select id, name, address from test_table");
		while(resultSet.next()) {
			System.out.print("Record >> ");
			System.out.print(resultSet.getInt(1));
			System.out.print(" | "+resultSet.getString(2));
			System.out.println(" | "+resultSet.getString(3));
		}
		//Test
		resultSet.close();
		statement.close();
		connection.close();
	}
}
