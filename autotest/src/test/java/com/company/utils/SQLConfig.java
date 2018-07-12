package com.company.utils;

public class SQLConfig {
	private static PropertiesPublic propertiesPublic=new PropertiesPublic("config.properties");
	public static final String MysqlUrl=propertiesPublic.getPropertiesValue("MysqlUrl");
	public static final String MysqlUsername=propertiesPublic.getPropertiesValue("MysqlUsername");
	public static final String MysqlPassword=propertiesPublic.getPropertiesValue("MysqlPassword");
	public static final String MysqlClass=propertiesPublic.getPropertiesValue("MysqlDriverClass");

}
