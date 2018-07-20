package com.company.utils.sql;

import java.sql.*;

class MysqlStatement {
	private Connection connection=null;
	private Statement stmt=null;//执行静态SQL语句，通过Statement实例实现
	ResultSet resultSet=null;
	int number;
	boolean flag;
	MysqlStatement(Connection connection){
		this.connection=connection;
		try{
			stmt=connection.createStatement();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	 void executeQueryUtil(String sql){
		//执行select语句
		try {
			resultSet=stmt.executeQuery(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	void executeUpdateUtil(String sql){
		//执行insert、update、delete、create table、drop table语句
		try{
			number=stmt.executeUpdate(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	void executeUtil(String sql){
		try{
			flag=stmt.execute(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	public void closeConnection(){
		if (connection!=null){
			try{
				connection.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	public void closeStmt(){
		if(stmt!=null){
			try{
				stmt.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}

	}
}
