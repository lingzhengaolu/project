package com.company.utils.sql;

import com.company.utils.pub.PropertiesPublic;

public class SQLConfig {
	private static PropertiesPublic propertiesPublic=new PropertiesPublic("config.properties");
	public static final String MysqlUrl=propertiesPublic.getPropertiesValue("MysqlUrl");
	public static final String MysqlUsername=propertiesPublic.getPropertiesValue("MysqlUsername");
	public static final String MysqlPassword=propertiesPublic.getPropertiesValue("MysqlPassword");
	public static final String MysqlClass=propertiesPublic.getPropertiesValue("MysqlDriverClass");
//	public static final String MongoUrl=propertiesPublic.getPropertiesValue("MongoUrl");
//	public static final int MongoPort=Integer.parseInt(propertiesPublic.getPropertiesValue("MongoPort"));
//	public static final String MongoUsername=propertiesPublic.getPropertiesValue("MongoUsername");
//	public static final String MongoPassword=propertiesPublic.getPropertiesValue("MongoPassword");

}
