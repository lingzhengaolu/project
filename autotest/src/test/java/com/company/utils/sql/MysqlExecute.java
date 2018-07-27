package com.company.utils.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

class MysqlExecute extends MysqlStatementProcessing{
	ResultSet resultSet=null;
	int number;
	boolean flag;
	MysqlExecute(Connection connection){
		super(connection);
	}

	void executeQueryUtil(int statementType,String sql,String ... value){
		//执行select语句
		switch (statementType){
			case 1:
				if(value.length>0){
					//demo
					break;
				}
				stmtProcessing();
				try {
					resultSet=stmt.executeQuery(sql);
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			case 2:
				if(value.length==0){
					pstmtProcessing(sql);
				}else {
					pstmtProcessing(sql,value);
				}
				try{
					resultSet=pstmt.executeQuery();
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			case 3:
				if(value.length==0){
					cstmtProcessing(sql);
				}else {
					cstmtProcessing(sql,value);
				}
				try{
					resultSet=cstmt.executeQuery();
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
				default:
					//demo
					break;
		}

	}
	void executeUpdateUtil(int statementType,String sql,String ... value){
		//执行insert、update、delete、create table、drop table语句
		switch (statementType){
			case 1:
				if(value.length>0){
					//demo
					break;
				}
				stmtProcessing();
				try {
					number=stmt.executeUpdate(sql);
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			case 2:
				if(value.length==0){
					pstmtProcessing(sql);
				}else {
					pstmtProcessing(sql,value);
				}
				try{
					number=pstmt.executeUpdate();
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			case 3:
				if(value.length==0){
					cstmtProcessing(sql);
				}else {
					cstmtProcessing(sql,value);
				}
				try{
					number=cstmt.executeUpdate();
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			default:
				//demo
				System.exit(0);
				break;
		}
	}
	void executeUtil(int statementType,String sql,String ... value){
		switch (statementType){
			case 1:
				if(value.length>0){
					//demo
					break;
				}
				stmtProcessing();
				try {
					flag=stmt.execute(sql);
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			case 2:
				if(value.length==0){
					pstmtProcessing(sql);
				}else {
					pstmtProcessing(sql,value);
				}
				try{
					flag=pstmt.execute();
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			case 3:
				if(value.length==0){
					cstmtProcessing(sql);
				}else {
					cstmtProcessing(sql,value);
				}
				try{
					flag=cstmt.execute();
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			default:
				//demo
				System.exit(0);
				break;
		}
	}
	public void closeResultSet(){
		try{
			resultSet.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

}
