package com.company.utils.sql;

import java.sql.Connection;
import java.sql.SQLException;

class MysqlStatementProcessing extends MysqlStatement{
	MysqlStatementProcessing(Connection connection){
		super(connection);
	}
	void stmtProcessing(){
		if(stmt==null){
			createStatement();
		}
	}
	void pstmtProcessing(String sql,String[] value){
		preparedStatement(sql);
		int length=value.length;
		for(int i=0;i<length;i++){
			try{
				pstmt.setString(i+1,value[i]);
			}catch (SQLException e){
				e.printStackTrace();
			}

		}
	}
	void pstmtProcessing(String sql){
		preparedStatement(sql);
	}
	void cstmtProcessing(String sql,String[] value){
		preparedStatement(sql);
		int length=value.length;
		for(int i=0;i<length;i++){
			try{
				cstmt.setString(i+1,value[i]);
			}catch (SQLException e){
				e.printStackTrace();
			}

		}
	}
	void cstmtProcessing(String sql){
		preparedStatement(sql);
		}

}
