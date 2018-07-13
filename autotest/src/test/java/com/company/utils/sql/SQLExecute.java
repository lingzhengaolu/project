package com.company.utils.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLExecute extends SQLStatement {
	public ResultSet resultSet=null;
	public int number;
	public boolean flag;
	public Statement stmt;
	public SQLExecute(Connection connection){
		super(connection);
		stmt=getStmt();
	}
	public ResultSet executeQueryUtil(String sql){
		//执行select语句
		try {
			resultSet=stmt.executeQuery(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}
		return resultSet;
	}
	public int executeUpdateUtil(String sql){
		//执行insert、update、delete、create table、drop table语句
		try{
			number=stmt.executeUpdate(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}
		return number;
	}
	public boolean executeUtil(String sql){
		try{
			flag=stmt.execute(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}
		return flag;
	}
}
