package com.company.utils.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlResultSetProcessing extends MysqlExecute {
	public MysqlResultSetProcessing(Connection connection){
		super(connection);
	}
	public ResultSet getResultSet(int statementType,String sql,String ... value){
		if(value.length==0){
			executeQueryUtil(statementType,sql);
		}else {
			executeQueryUtil(statementType,sql,value);
		}
		return resultSet;
	}
	public String getValue(int statementType,String sql,String key,String ... values){
		String value=null;
		if(values.length==0){
			executeQueryUtil(statementType,sql);
		}else {
			executeQueryUtil(statementType,sql,values);
		}
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
