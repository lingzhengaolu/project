package com.company.pages;

import com.company.utils.pub.PropertiesPublic;

public class URLConfig {
	private static PropertiesPublic propertiesPublic=new PropertiesPublic("config.properties");
	public static final String URL=propertiesPublic.getPropertiesValue("url");
}
