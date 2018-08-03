package com.company.uiframework;

import com.company.utils.sql.MysqlSelect;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.util.HashMap;

public class WebElementUtils extends DriverUtils{
	public MysqlSelect mysqlSelect;
	private HashMap<String,LocatorE> locatorHashMap;
	public WebElementUtils(Connection connection, WebDriver driver){
		super(connection,driver);
		this.mysqlSelect=new MysqlSelect(connection);
		locatorHashMap=ElementDataProcessing.readElementInfo(mysqlSelect,this.getClass().getSimpleName());
	}
	public LocatorE getLocator(String locatorName){
		LocatorE locatorE =null;
		locatorE =locatorHashMap.get(locatorName);
		return locatorE;
	}
	private WebElement getElement(LocatorE locatorE){
		WebElement element=null;
		switch (locatorE.getEleRecMethod()){
			case "id":
				element=driver.findElement(By.id(locatorE.getEleRoute()));
				break;
			case "name":
				element=driver.findElement(By.name(locatorE.getEleRoute()));
				break;
			case "xpath":
				element=driver.findElement(By.xpath(locatorE.getEleRoute()));
				break;
			case "css":
				element=driver.findElement(By.cssSelector(locatorE.getEleRoute()));
				break;
			case "linktext":
				element=driver.findElement(By.linkText(locatorE.getEleRoute()));
				break;
			default:
				System.out.println(locatorE.getEleRecMethod());
				System.out.println("暂无处理"+ locatorE.getEleRecMethod()+"识别方式，请修改源码！");
				break;
		}
		return element;
	}
	public WebElement findElement(LocatorE locatorE){
		WebDriverWait wait = new WebDriverWait(driver, locatorE.getTimeOut());
		WebElement element = wait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver dr)
			{
				return getElement(locatorE);
			}
		});
		return element;
	}
	public String getPageSource(){
		String value=null;
		value=driver.getPageSource();
		return value;
	}
	public HashMap<String,Integer> getObjectSize(LocatorE locatorE){
		WebElement element=findElement(locatorE);
		HashMap<String,Integer> hashMap=new HashMap<>();
		int height=element.getSize().height;
		int width=element.getSize().width;
		hashMap.put("height",height);
		hashMap.put("width",width);
		return hashMap;
	}
	public Boolean objectIsDisplayed(LocatorE locatorE){
		//判断对象是否可见
		WebElement element=findElement(locatorE);
		boolean value=element.isDisplayed();
		return value;
	}
	public Boolean objectIsEnabled(LocatorE locatorE){
		//判断对象是否被禁用
		WebElement element=findElement(locatorE);
		boolean value=element.isEnabled();
		return value;
	}
	public Boolean objectIsSelected(LocatorE locatorE){
		//判断对象是否被选中
		WebElement element=findElement(locatorE);
		boolean value=element.isSelected();
		return value;
	}
	public String getObjectTagName(LocatorE locatorE){
		//获取对象标签名称
		WebElement element=findElement(locatorE);
		String value=element.getTagName();
		return value;
	}
	public HashMap<String, Integer> getObjectLocation(LocatorE locatorE){
		//获取对象坐标
		WebElement element=findElement(locatorE);
		HashMap<String,Integer> hashMap=new HashMap<>();
		int x=element.getLocation().x;
		int y=element.getLocation().y;
		hashMap.put("x",x);
		hashMap.put("y",y);
		return hashMap;
	}
	public void click(LocatorE locatorE){
		WebElement element=findElement(locatorE);
		element.click();
	}
	public void input(LocatorE locatorE, String value){
		WebElement element=findElement(locatorE);
		element.sendKeys(value);
	}
	public void clearInput(LocatorE locatorE){
		WebElement element=findElement(locatorE);
		element.clear();
	}
	public void submit(LocatorE locatorE){
		WebElement element=findElement(locatorE);
		element.submit();
	}
	public String getText(LocatorE locatorE){
		String value=null;
		WebElement element=findElement(locatorE);
		value=element.getText();
		return value;
	}
	public String getAttribute(LocatorE locatorE, String attributename){
		String value=null;
		WebElement el=findElement(locatorE);
		value=el.getAttribute(attributename);
		return value;
	}
	public void selector(LocatorE locatorE, String value){
		WebElement element=findElement(locatorE);
		Select select=new Select(element);
		select.selectByVisibleText(value);//匹配可见字符
	}

}
