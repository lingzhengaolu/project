package com.company.utils.sql;

import java.sql.*;

class MysqlStatement {
	Connection connection;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	CallableStatement cstmt=null;
	MysqlStatement(Connection connection){
		this.connection=connection;
	}

	void createStatement(){
		try{
			stmt=connection.createStatement();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	void preparedStatement(String sql){
		try{
			pstmt=connection.prepareStatement(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	void callableStatement(String sql){
		//执行存储过程
		try{
			cstmt=connection.prepareCall(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}


    public void closestmt(){
		if(stmt!=null){
			try{
				stmt.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try{
				pstmt.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		if(cstmt!=null){
			try{
				cstmt.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

}
