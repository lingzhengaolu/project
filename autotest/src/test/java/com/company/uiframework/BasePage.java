package com.company.uiframework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Connection;

public class BasePage extends WebElementUtils{
	public BasePage(Connection connection, WebDriver driver){
		super(connection,driver);
	}


	public void switchToFrame(LocatorE locatorE){
		WebElement el=findElement(locatorE);
		boolean flag=false;
		int num=0;
		while (!flag){
			try{
				driver.switchTo().frame(el);
				flag=true;
			}catch (Exception e){
				e.printStackTrace();
				num=num+1;
				wait(1);
				if(num>=10){
					System.out.println("切换入frame框失败！");
					break;
				}
			}
		}

	}
	//切出frame框
	public void switchOutFrame(){
		boolean flag=false;
		int num=0;
		while (!flag){
			try{
				driver.switchTo().defaultContent();
				flag=true;
			}catch (Exception e){
				e.printStackTrace();
				num=num+1;
				wait(1);
				if(num>=10){
					System.out.println("切出frame框失败！");
					break;
				}
			}
		}
	}
	//点击alert弹窗确定按钮
	public void alertAccept(){
		boolean flag=false;
		int num=0;
		while (!flag){
			try{
				Alert alert=driver.switchTo().alert();
				alert.accept();
				flag=true;
			}catch (Exception e){
				e.printStackTrace();
				num=num+1;
				wait(1);
				if(num>=10){
					System.out.println("获取alert弹窗失败或者accept()失败！");
					break;
				}
			}
		}
	}
	//点击alert弹窗取消按钮
	public void alertDismiss(){
		boolean flag=false;
		int num=0;
		while (!flag){
			try{
				Alert alert=driver.switchTo().alert();
				alert.dismiss();
				flag=true;
			}catch (Exception e){
				e.printStackTrace();
				num=num+1;
				wait(1);
				if(num>=10){
					System.out.println("获取alert弹窗或者dismiss()失败！");
					break;
				}
			}
		}

	}
	//获取alert弹窗文本
	public String getAlertText(){
		String raw=null;
		boolean flag=false;
		int num=0;
		while (!flag){
			try{
				Alert alert=driver.switchTo().alert();
				raw=alert.getText();
				flag=true;
			}catch (Exception e){
				e.printStackTrace();
				num=num+1;
				wait(1);
				if(num>=10){
					System.out.println("获取alert弹窗或者getText()失败！");
					break;
				}
			}
		}
		return raw;
	}
	//向alert弹窗输入数据
	public void inputAlert(String value){
		boolean flag=false;
		int num=0;
		while (!flag){
			try{
				Alert alert=driver.switchTo().alert();
				alert.sendKeys(value);
				wait(0.5);
				alert.accept();
				flag=true;
			}catch (Exception e){
				e.printStackTrace();
				num=num+1;
				wait(1);
				if(num>=10){
					System.out.println("获取alert弹窗或者sendKeys(value)失败！");
					break;
				}
			}
		}
	}
	private String javascriptPublic(String script){
		String value;
		value = (String)((JavascriptExecutor)driver).executeScript(script);
		if(value==null||value.equalsIgnoreCase("null")){
			value="";
		}
		return value;
	}

	public String javascriptCode(LocatorE locatorE,int length){
		//验证码输入框专用,直接监测网页输入框内容
		String value="";
		while ((value=javascriptPublic("return document.getElementById('"+locatorE.getEleRoute()+"').value")).length()!=length){
			System.out.println(value);
			wait(locatorE.getTimeOut());
		}
		return value;
	}

}
