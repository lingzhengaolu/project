package com.company.uiframework;

import com.company.utils.sql.SQLExecute;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ElementDataProcessing {
	public static HashMap<String,Locator> readElementInfo(Connection connection,String classSimpleName){
		SQLExecute sqlExecute=new SQLExecute(connection);
		sqlExecute.executeQueryUtil(1,"select * from"+" "+"E_"+classSimpleName);
		ResultSet resultSet=sqlExecute.resultSet;
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
		try {
			resultSet.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		try{
			sqlExecute.stmt.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return elementinfos;

	}
}
