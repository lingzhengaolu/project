package com.company.utils.sql;

import java.sql.Connection;

public class SQLExPreProcessing extends SQLStatement{

	public SQLExPreProcessing(Connection connection){
		super(connection);
	}
	public void psxxxx(String sql){
		//未知的PreparedStatement中间处理方法
		getPstmt(sql);

	}
	public void csxxxx(String sql){
		//未知的CallableStatement中间处理方法
		getCstmt(sql);

	}


}
