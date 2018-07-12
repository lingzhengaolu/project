package com.company.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	public Connection connection=null;
	public Connection getConnection(String url,String username,String password,String driverclass) {
		try {
			Class.forName(driverclass);
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			connection=DriverManager.getConnection(url,username,password);
		}catch (SQLException e){
			e.printStackTrace();
		}

		return connection;
	}
}
