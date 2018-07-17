package com.company.utils.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SQLExecute extends SQLExPreProcessing {
	public ResultSet resultSet=null;
	private int number;
	private boolean flag;
	public SQLExecute(Connection connection){
		super(connection);
	}
	public void executeQueryUtil(int type,String sql){
		//执行select语句
		switch (type){
			case 1:
				getStmt();
				try {
					resultSet=stmt.executeQuery(sql);
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			case 2:
				psxxxx(sql);//demo
				try {
					resultSet=pstmt.executeQuery(sql);
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			case 3:
				csxxxx(sql);//demo
				try {
					resultSet=cstmt.executeQuery(sql);
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
				default:
					System.out.println("type error!");
					break;
		}
	}
	public int executeUpdateUtil(int type,String sql){
		//执行insert、update、delete、create table、drop table语句
		switch (type){
			case 1:
				getStmt();
				try{
					number=stmt.executeUpdate(sql);
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			case 2:
				psxxxx(sql);//demo
				try{
					number=pstmt.executeUpdate(sql);
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			case 3:
				csxxxx(sql);//demo
				try{
					number=cstmt.executeUpdate(sql);
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("type error!");
				break;
		}
		return number;
	}
	public boolean executeUtil(int type,String sql){
		switch (type){
			case 1:
				getStmt();
				try{
					flag=stmt.execute(sql);
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			case 2:
				psxxxx(sql);//demo
				try{
					flag=pstmt.execute(sql);
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			case 3:
				csxxxx(sql);//demo
				try{
					flag=cstmt.execute(sql);
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("type error!");
				break;
		}
		return flag;
	}
}
