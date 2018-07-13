package com.company.utils.sql;

import java.sql.*;

public class SQLStatement{
	public Connection connection=null;
	public Statement stmt=null;//执行静态SQL语句，通过Statement实例实现
	public PreparedStatement pstmt=null;//执行动态SQL语句,通过PreparedStatement实例实现
	public CallableStatement cstmt=null;//执行数据库存储过程,通过CallableStatement实例实现
	public SQLStatement(Connection connection){
		this.connection=connection;
	}
	public Statement getStmt(){
		try{
			stmt=connection.createStatement();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return stmt;
	}
	public PreparedStatement getPstmt(String sql){
		try{
			pstmt=connection.prepareStatement(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}
		return pstmt;
	}
	public CallableStatement getCstmt(String sql){
		try{
			cstmt=connection.prepareCall(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}
		return cstmt;
	}
}
