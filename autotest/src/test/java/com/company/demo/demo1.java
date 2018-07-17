package com.company.demo;

import com.company.utils.pub.GetpathPublic;
import com.company.utils.pub.SelectFilePublic;

public class demo1 {
	public static void main(String []args){
//		SQLConnection sqlConnection=new SQLConnection();
//		System.out.println(sqlConnection.getConnection(SQLConfig.MysqlUrl,SQLConfig.MysqlUsername,SQLConfig.MysqlPassword,SQLConfig.MysqlClass));
//		SelectFilePublic selectFilePublic=new SelectFilePublic();
//
//
//		System.out.println(selectFilePublic.PATH);
		System.out.println(GetpathPublic.ProjectPath);
	}
}
