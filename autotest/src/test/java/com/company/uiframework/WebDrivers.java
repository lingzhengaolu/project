package com.company.uiframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class WebDrivers {
	private WebDriver timeOut(WebDriver driver){
		driver.manage().timeouts().pageLoadTimeout(DriverConfig.pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(DriverConfig.setScriptTimeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(DriverConfig.implicitlyWait,TimeUnit.SECONDS);
		return driver;
	}
	public WebDriver firefoxDriver(){
		WebDriver driver=null;
		DesiredCapabilities desiredCapabilities;
		System.setProperty("webdriver.firefox.bin", DriverConfig.firefoxbrowser);
		System.setProperty("webdriver.gecko.driver", DriverConfig.firefoxdriverpath);
		desiredCapabilities=DesiredCapabilities.firefox();
		desiredCapabilities.setCapability("marionette",true);
		driver=new FirefoxDriver(desiredCapabilities);
		driver=timeOut(driver);
		return driver;
	}
	public WebDriver chromefoxDriver(){
		WebDriver driver=null;
		DesiredCapabilities desiredCapabilities;
		System.setProperty("webdriver.chrome.bin", DriverConfig.chromebrowser);
		System.setProperty("webdriver.chrome.driver", DriverConfig.chromedriverpath);
		desiredCapabilities=DesiredCapabilities.chrome();
		desiredCapabilities.setCapability("marionette",true);
		driver=new FirefoxDriver(desiredCapabilities);
		driver=timeOut(driver);
		return driver;
	}
}
