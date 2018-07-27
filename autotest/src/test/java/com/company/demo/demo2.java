package com.company.demo;

import com.company.pages.LoginPage;
import com.company.testcases.TestCaseDataProcessing;
import com.company.thread.DataInsertIntoMysql;
import com.company.thread.UpdateMysqlData;
import com.company.uiframework.WebDrivers;
import com.company.utils.pub.ReadJSON;
import com.company.utils.sql.MysqlSelect;
import com.company.utils.sql.SQLConnection;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;

public class demo2 {
	public static void main(String[] args){
		SQLConnection sqlConnection=new SQLConnection();
		Connection connection=sqlConnection.getMysqlConnection();
		WebDriver driver=new WebDrivers().chromeDriver();
		DataInsertIntoMysql dataInsertIntoMysql=new DataInsertIntoMysql(connection);
		dataInsertIntoMysql.uploadElementData();
		dataInsertIntoMysql.uploadCaseData();
		UpdateMysqlData updateMysqlData=new UpdateMysqlData(connection);
		updateMysqlData.updateElement();
		updateMysqlData.updateCase();
		dataInsertIntoMysql.close();
		updateMysqlData.close();
		LoginPage loginPage=new LoginPage(connection,driver);

		MysqlSelect mysqlSelect=new MysqlSelect(connection);
		ReadJSON readJSON=new ReadJSON(TestCaseDataProcessing.getTestCaseData(mysqlSelect,"1").getTestcase());
		loginPage.loginOperate(readJSON.getValue("name"),readJSON.getValue("password"));

		loginPage.wait(40);
		loginPage.quit();

		sqlConnection.close();





	}
}
