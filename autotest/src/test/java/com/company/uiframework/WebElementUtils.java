package com.company.uiframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.util.HashMap;

public class WebElementUtils extends DriverUtils{
	protected HashMap<String,Locator> locatorHashMap;
	public WebElementUtils(Connection connection, WebDriver driver){
		super(connection,driver);
		locatorHashMap=ElementDataProcessing.readElementInfo(connection,this.getClass().getSimpleName());
	}
	public Locator getLocator(String locatorName){
		Locator locator=null;
		locator=locatorHashMap.get(locatorName);
		return locator;
	}
	private WebElement getElement(Locator locator){
		WebElement element=null;
		switch (locator.getEleRecMethod()){
			case "id":
				element=driver.findElement(By.id(locator.getEleRoute()));
				break;
			case "name":
				element=driver.findElement(By.name(locator.getEleRoute()));
				break;
			case "xpath":
				element=driver.findElement(By.xpath(locator.getEleRoute()));
				break;
			case "cssSelector":
				element=driver.findElement(By.cssSelector(locator.getEleRoute()));
				default:
					System.out.println("暂无处理"+locator.getEleRecMethod()+"识别方式，请修改源码！");
					break;
		}
		return element;
	}
	public WebElement findElement(Locator locator){
		WebDriverWait wait = new WebDriverWait(driver, locator.getTimeOut());
		WebElement element = wait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver dr)
			{
				return getElement(locator);
			}
		});
		return element;
	}
	public String getPageSource(){
		String value=null;
		value=driver.getPageSource();
		return value;
	}
	public void input(Locator locator,String value){
		WebElement element=findElement(locator);
		element.sendKeys(value);
	}
	public void clearInput(Locator locator){
		WebElement element=findElement(locator);
		element.clear();
	}
	public void submit(Locator locator){
		WebElement element=findElement(locator);
		element.submit();
	}
	public String getText(Locator locator){
		String value=null;
		WebElement element=findElement(locator);
		value=element.getText();
		return value;
	}
	public String getAttribute(Locator locator,String attributename){
		String value=null;
		WebElement el=findElement(locator);
		value=el.getAttribute(attributename);
		return value;
	}
	public void selector(Locator locator,String value){
		WebElement element=findElement(locator);
		Select select=new Select(element);
		select.selectByVisibleText(value);//匹配可见字符
	}

}
