package com.company.uiframework;

import com.company.utils.sql.MysqlResultSetProcessing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ElementDataProcessing {
	public static HashMap<String,Locator> readElementInfo(Connection connection,String classSimpleName){
		MysqlResultSetProcessing mysqlResultSetProcessing=new MysqlResultSetProcessing(connection);
		ResultSet resultSet=mysqlResultSetProcessing.getResultSet(2,"select * from E_?",classSimpleName);
		HashMap<String,Locator> elementinfos=new HashMap<String, Locator>();
		try{
			while (resultSet.next()){
				String controlCode=resultSet.getString("controlCode").trim();
				String controlName=resultSet.getString("controlName").trim();
				String eleRecMethod=resultSet.getString("eleRecMethod").trim();
				String eleRoute=resultSet.getString("eleRoute").trim();
				int timeOut=Integer.parseInt(resultSet.getString("timeOut").trim());
				Locator locator=new Locator(controlCode,controlName,eleRecMethod,eleRoute,timeOut);
				elementinfos.put(controlCode,locator);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		mysqlResultSetProcessing.closeResultSet();
		mysqlResultSetProcessing.closeStmt();
		return elementinfos;
	}
}
