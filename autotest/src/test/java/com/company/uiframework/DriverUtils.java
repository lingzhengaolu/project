package com.company.uiframework;

import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DriverUtils {
	protected WebDriver driver;
	protected Connection connection;
	public DriverUtils(Connection connection,WebDriver driver){
		this.connection=connection;
		this.driver=driver;
	}
	public void wait(int second){
		try{
			Thread.sleep(second*1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void wait(double second){
		try{
			Thread.sleep((int)second*1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void openWeb(String url){
		try{
			driver.get(url);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void back(){
		try{
			driver.navigate().back();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void forward(){
		try{
			driver.navigate().forward();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void refresh(){
		try{
			driver.navigate().refresh();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void switchToHandle(int index){
		try{
			Set<String> winhandels=driver.getWindowHandles();
			List<String> it=new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(it.get(index));
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	//正则表达式封装
	public String regularGetData(String regEx,String strResult){
		String result=null;
		try{
			Pattern pattern = Pattern.compile(regEx);
			Matcher matcher = pattern.matcher(strResult);
			while (matcher.find()) {
				result=matcher.group(1);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}
	public void quit(){
		driver.quit();
	}
}
