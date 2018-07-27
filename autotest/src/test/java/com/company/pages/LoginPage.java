package com.company.pages;

import com.company.uiframework.BasePage;
import com.company.uiframework.LocatorE;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;

public class LoginPage extends BasePage {
	private LocatorE usernameInputBox;
	private LocatorE passwordInputBox;
	private LocatorE codeInputBox;
	private LocatorE loginButton;
	public LoginPage(Connection connection, WebDriver driver){
		super(connection,driver);
		openWeb(URLConfig.URL);
		usernameInputBox=getLocator("usernameInputBox");
		passwordInputBox=getLocator("passwordInputBox");
		codeInputBox=getLocator("codeInputBox");
		loginButton=getLocator("loginButton");
	}
	public void loginOperate(String name,String password){
		input(usernameInputBox,name);
		input(passwordInputBox,password);
		//input(codeInputBox,"7894");
		while (javascript("return document.getElementById('code').value").length()!=4){
			System.out.println(javascript("return document.getElementById('code').value"));
			wait(2);
		}
		System.out.println(javascript("return document.getElementById('code').value"));
		//click(loginButton);
	}
}
