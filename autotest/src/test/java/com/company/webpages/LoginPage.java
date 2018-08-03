package com.company.webpages;

import com.company.uiframework.BasePage;
import com.company.uiframework.LocatorE;
import com.company.webpages.config.URLConfig;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;

public class LoginPage extends BasePage {
	private LocatorE
			usernameInputBox,
			passwordInputBox,
			codeInputBox,
			codeInputBoxJS,
			loginButton;
	public LoginPage(Connection connection, WebDriver driver){
		super(connection,driver);
		openWeb(URLConfig.URL);
		usernameInputBox=getLocator("usernameInputBox");
		passwordInputBox=getLocator("passwordInputBox");
		codeInputBox=getLocator("codeInputBox");
		loginButton=getLocator("loginButton");
		codeInputBoxJS=getLocator("codeInputBox_js");
	}
	public MainPage loginOperate(String name,String password){
		//该方法在没有万能验证码前提下使用
		input(usernameInputBox,name);
		input(passwordInputBox,password);
		javascriptCode(codeInputBoxJS,4);
		click(loginButton);
		return new MainPage(connection,driver);
	}
	public MainPage loginOperate(String name,String password,String code){
		//该方法必须提供万能验证码，并且提供万能验证码后，可以完全进行自动化测试，无需人工干预
		input(usernameInputBox,name);
		input(passwordInputBox,password);
		input(codeInputBox,code);
		click(loginButton);
		return new MainPage(connection,driver);
	}
	public String loginFail(String name,String password,String code){
		//该方法为登录失败方法，并返回js弹窗的错误提示信息
		input(usernameInputBox,name);
		input(passwordInputBox,password);
		input(codeInputBox,code);
		click(loginButton);
		String value=getAlertText();
		return value;
	}
}
