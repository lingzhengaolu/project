package com.company.uiframework;

import com.company.utils.sql.MysqlSelect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ElementDataProcessing {
	public static HashMap<String,LocatorE> readElementInfo(MysqlSelect mysqlSelect, String classSimpleName){
		ResultSet resultSet=mysqlSelect.selectElement(classSimpleName);
		HashMap<String,LocatorE> elementinfos=new HashMap<String, LocatorE>();
		try{
			while (resultSet.next()){
				String controlCode=resultSet.getString("controlCode").trim();
				String controlName=resultSet.getString("controlName").trim();
				String eleRecMethod=resultSet.getString("eleRecMethod").trim();
				String eleRoute=resultSet.getString("eleRoute").trim();
				int timeOut=Integer.parseInt(resultSet.getString("timeOut").trim());
				LocatorE locatorE =new LocatorE(controlCode,controlName,eleRecMethod,eleRoute,timeOut);
				elementinfos.put(controlCode, locatorE);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		mysqlSelect.closeResultSet();
		mysqlSelect.closestmt();
		return elementinfos;
	}
}
