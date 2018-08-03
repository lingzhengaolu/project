package com.company.testcases.pub;

import com.company.utils.sql.MysqlSelect;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestCaseDataProcessing {
	public static LocatorC getTestCaseData(MysqlSelect mysqlSelect,String id){
		LocatorC locatorC=null;
		ResultSet resultSet=mysqlSelect.selectCasedata(id);
		try{
			resultSet.next();
			String ID=resultSet.getString("id").trim();
			String group=resultSet.getString("group").trim();
			String testcase=resultSet.getString("testcase").trim();
			String expectedResults=resultSet.getString("expectedResults").trim();
			locatorC=new LocatorC(ID,group,testcase,expectedResults);

		}catch (SQLException e){
			e.printStackTrace();
		}
		mysqlSelect.closeResultSet();
		mysqlSelect.closestmt();
		return locatorC;
	}
}
