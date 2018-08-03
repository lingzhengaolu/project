package com.company.testcases.functioncase;

import com.company.uiframework.Asserts;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import java.sql.Connection;

public class LoginTest {
	Connection connection;
	WebDriver driver;
	Asserts asserts;

	@BeforeMethod
	public void open(){
		/*
		本地环境检测
		本地数据检测
		连接数据库
		数据库检测
		数据库table检测
		数据插入或更新
		更新情况反馈到excel，并清除操作类型
		 */
	}

}
