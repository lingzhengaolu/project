package com.company.utils.sql;

import java.sql.Connection;
import java.sql.ResultSet;

public class MysqlSelect extends MysqlExecute{
	public MysqlSelect(Connection connection){
		super(connection);
	}
	public ResultSet selectElement(String classSimpleName){
		String sql="select * from E_"+classSimpleName;
		executeQueryUtil(2,sql);
		return resultSet;
	}
	public ResultSet selectCasedata(String id){
		String sql="select * from testCaseData where id=?";
		executeQueryUtil(2,sql,id);
		return resultSet;
	}

}
