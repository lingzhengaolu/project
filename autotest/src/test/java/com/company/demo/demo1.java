package com.company.demo;

import com.company.utils.SelectFilePublic;
import com.company.utils.sql.SQLConfig;
import com.company.utils.sql.SQLConnection;

public class demo1 {
	public static void main(String []args){
//		SQLConnection sqlConnection=new SQLConnection();
//		System.out.println(sqlConnection.getConnection(SQLConfig.MysqlUrl,SQLConfig.MysqlUsername,SQLConfig.MysqlPassword,SQLConfig.MysqlClass));
		SelectFilePublic selectFilePublic=new SelectFilePublic();


		System.out.println(selectFilePublic.PATH);
	}
}
