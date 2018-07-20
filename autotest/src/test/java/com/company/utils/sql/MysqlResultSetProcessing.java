package com.company.utils.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlResultSetProcessing extends MysqlStatement {
	public MysqlResultSetProcessing(Connection connection){
		super(connection);
	}
	public ResultSet getResultSet(String sql){
		executeQueryUtil(sql);
		return resultSet;
	}
	public String getValue(String sql,String key){
		String value=null;
		executeQueryUtil(sql);
		try{
			value=resultSet.getString(key);
		}catch (SQLException e){
			e.printStackTrace();
		}
		return value;
	}
	public void closeResultSet(){
		try{
			resultSet.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

}
