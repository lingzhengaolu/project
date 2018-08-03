package com.company.uiframework;

import com.company.utils.sql.MysqlSelect;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DriverUtils {
	protected WebDriver driver;
	protected Connection connection;
	public DriverUtils(Connection connection,WebDriver driver){
		this.driver=driver;
		this.connection=connection;
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
	public String getUrl(){
		String value;
		value=driver.getCurrentUrl();
		return value;
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
	public ArrayList<HashMap<String,String>> getCookies(){
		Set<Cookie> cookies=driver.manage().getCookies();
		ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
		for(Cookie cookie:cookies){
			HashMap<String,String> hashMap=new HashMap<>();
			hashMap.put("name",cookie.getName());//名称
			hashMap.put("path",cookie.getPath());//路径
			hashMap.put("value",cookie.getValue());//值
			hashMap.put("expiry",cookie.getExpiry().toString());//有效时间
			hashMap.put("domain",cookie.getDomain());//作用域
			arrayList.add(hashMap);
		}
		return arrayList;
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
