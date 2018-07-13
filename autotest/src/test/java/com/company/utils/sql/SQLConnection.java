package com.company.utils.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	public Connection connection=null;
	public Connection getConnection(String driverclass,String url,String username,String password) {
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
