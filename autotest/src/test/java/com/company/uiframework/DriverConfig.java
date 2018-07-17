package com.company.uiframework;

import com.company.utils.pub.PropertiesPublic;

public class DriverConfig {
	private static PropertiesPublic propertiesPublic=new PropertiesPublic("config.properties");
	public static final String chromebrowser=propertiesPublic.getPropertiesValue("chromebrowser");
	public static final String chromedriverpath=propertiesPublic.getPropertiesValue("chromedriverpath");
	public static final String firefoxbrowser=propertiesPublic.getPropertiesValue("firefoxbrowser");
	public static final String firefoxdriverpath=propertiesPublic.getPropertiesValue("firefoxdriverpath");
	public static final int pageLoadTimeout=Integer.parseInt(propertiesPublic.getPropertiesValue("pageLoadTimeout"));
	public static final int setScriptTimeout=Integer.parseInt(propertiesPublic.getPropertiesValue("setScriptTimeout"));
	public static final int implicitlyWait=Integer.parseInt(propertiesPublic.getPropertiesValue("implicitlyWait"));
}
