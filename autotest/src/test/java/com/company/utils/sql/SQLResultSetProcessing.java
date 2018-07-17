package com.company.utils.sql;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLResultSetProcessing extends SQLExecute {
	private String value=null;
	public SQLResultSetProcessing(Connection connection){
		super(connection);
	}
	public String getValue(int type,String sql,String key){
		executeQueryUtil(type,sql);
		try{
			value=resultSet.getString(key);
		}catch (SQLException e){
			e.printStackTrace();
		}
		return value;
	}

}
