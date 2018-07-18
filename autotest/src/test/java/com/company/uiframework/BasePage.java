package com.company.uiframework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Connection;

public class BasePage extends WebElementUtils{
	public BasePage(Connection connection, WebDriver driver){
		super(connection,driver);
	}
	public void switchToFrame(Locator locator){
		WebElement el=findElement(locator);
		try{
			driver.switchTo().frame(el);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	//切出frame框
	public void switchOutFrame(){
		try{
			driver.switchTo().defaultContent();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	//点击alert弹窗确定按钮
	public void alertAccept(){
		try{
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	//点击alert弹窗取消按钮
	public void alertDismiss(){
		try{
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
		}catch (Exception e){
			e.printStackTrace();
		}

	}
	//获取alert弹窗文本
	public String getAlertText(){
		String raw=null;
		try{
			Alert alert=driver.switchTo().alert();
			raw=alert.getText();
		}catch (Exception e){
			e.printStackTrace();
		}
		return raw;
	}
	//向alert弹窗输入数据
	public void inputAlert(String value){
		try{
			Alert alert=driver.switchTo().alert();
			alert.sendKeys(value);
			wait(1);
			alert.accept();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
