package com.company.demo;

import com.company.utils.sql.*;

import java.sql.Connection;

public class demo1 {
	public static void main(String []args){
//		SQLConnection sqlConnection=new SQLConnection();
//		System.out.println(sqlConnection.getConnection(SQLConfig.MysqlUrl,SQLConfig.MysqlUsername,SQLConfig.MysqlPassword,SQLConfig.MysqlClass));
//		SelectFilePublic selectFilePublic=new SelectFilePublic();
//
//
//		System.out.println(selectFilePublic.PATH);
		//System.out.println(GetpathPublic.ProjectPath);
		//ErrorDialog.errorDialog("标题","是hi hi i");
//		ArrayList<String> value=new ArrayList<String>();
//		for(int i=0;i<10;i++){
//			value.add(String.valueOf(i));
//		}
//		System.out.println(value);
//		SelectFilePublic selectFilePublic=new SelectFilePublic();
//		IOPublic ioPublic=new IOPublic(selectFilePublic.PATH);
//		ArrayList<String> arrayList=ioPublic.read();
//		for(String i:arrayList){
//			System.out.println(i);
//		}
//		Excel excel=new Excel(selectFilePublic.PATH,"sheet1");
//		String data[][]=excel.readExcel();
//		System.out.println(excel.getColoumNum());
//		System.out.println(excel.getRowNum());
//		for(int i=0;i<data.length;i++){
//			for(int j=0;j<data[i].length;j++){
//				System.out.printf(data[i][j]+"\t");
//			}
//			System.out.println();
//		}
//		System.out.println(excel.getColoumNum());
//		System.out.println(excel.getRowNum());
//		String[][] a=new String[][]{{"1","2","311111111111111111111111111111111111111111111","4"},{"1","2","3","4"}};
//		System.out.println(a.length);
//		System.out.println(a[0].length);
//		Excel excel=new Excel("D:\\78.xl","开幕式");
//		excel.createExcel(a);
		SQLConnection sqlConnection=new SQLConnection();
		Connection connection=sqlConnection.getConnection(SQLConfig.MysqlClass,SQLConfig.MysqlUrl,SQLConfig.MysqlUsername,SQLConfig.MysqlPassword);
		MysqlCreate mySqlCreate =new MysqlCreate(connection);
		for(int i=0;i<1000;i++){
			mySqlCreate.createDataBase("kms1");
			System.out.println(mySqlCreate.getFlag());
			mySqlCreate.useDataBase("kms1");
			System.out.println(mySqlCreate.getFlag());
			mySqlCreate.createTable("kms");
			System.out.println(mySqlCreate.getFlag());

		}
		mySqlCreate.closeStmt();
		mySqlCreate.closeConnection();



	}
}
