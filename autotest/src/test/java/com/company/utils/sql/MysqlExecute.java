package com.company.utils.sql;

import com.company.utils.ui.promptbox.ErrorDialog;

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
					ErrorDialog.errorDialog("处理语句","statementType值为1时，不能传入参数value");
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
					ErrorDialog.errorDialog("处理语句","statementType值为2时，必须传入参数value");
					break;
				}
				pstmtProcessing(sql,value);
				try{
					resultSet=pstmt.executeQuery();
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			case 3:
				if(value.length==0){
					ErrorDialog.errorDialog("处理语句","statementType值为3时，必须传入参数value");
					break;
				}
				cstmtProcessing(sql,value);
				try{
					resultSet=cstmt.executeQuery();
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
				default:
					ErrorDialog.errorDialog("处理语句","statementType超出设定范围[1,3]");
					break;
		}

	}
	void executeUpdateUtil(int statementType,String sql,String ... value){
		//执行insert、update、delete、create table、drop table语句
		switch (statementType){
			case 1:
				if(value.length>0){
					ErrorDialog.errorDialog("处理语句","statementType值为1时，不能传入参数value");
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
					ErrorDialog.errorDialog("处理语句","statementType值为2时，必须传入参数value");
					break;
				}
				pstmtProcessing(sql,value);
				try{
					number=pstmt.executeUpdate();
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			case 3:
				if(value.length==0){
					ErrorDialog.errorDialog("处理语句","statementType值为3时，必须传入参数value");
					break;
				}
				cstmtProcessing(sql,value);
				try{
					number=cstmt.executeUpdate();
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			default:
				ErrorDialog.errorDialog("处理语句","statementType超出设定范围[1,3]");
				System.exit(0);
				break;
		}
	}
	void executeUtil(int statementType,String sql,String ... value){
		switch (statementType){
			case 1:
				if(value.length>0){
					ErrorDialog.errorDialog("处理语句","statementType值为1时，不能传入参数value");
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
					ErrorDialog.errorDialog("处理语句","statementType值为2时，必须传入参数value");
					break;
				}
				pstmtProcessing(sql,value);
				try{
					flag=pstmt.execute();
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			case 3:
				if(value.length==0){
					ErrorDialog.errorDialog("处理语句","statementType值为3时，必须传入参数value");
					break;
				}
				cstmtProcessing(sql,value);
				try{
					flag=cstmt.execute();
				}catch (SQLException e){
					e.printStackTrace();
				}
				break;
			default:
				ErrorDialog.errorDialog("处理语句","statementType超出设定范围[1,3]");
				System.exit(0);
				break;
		}
	}


}
