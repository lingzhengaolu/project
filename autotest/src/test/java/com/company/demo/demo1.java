package com.company.demo;

import com.company.utils.excel.Excel;
import com.company.utils.pub.GetpathPublic;
import com.company.utils.pub.IOPublic;
import com.company.utils.pub.SelectFilePublic;
import com.company.utils.ui.promptbox.ErrorDialog;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

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
		SelectFilePublic selectFilePublic=new SelectFilePublic();
//		IOPublic ioPublic=new IOPublic(selectFilePublic.PATH);
//		ArrayList<String> arrayList=ioPublic.read();
//		for(String i:arrayList){
//			System.out.println(i);
//		}
		Excel excel=new Excel();
		String data[][]=excel.readExcel(selectFilePublic.PATH,"sheet1");

		for(int i=0;i<data.length;i++){
			for(int j=0;j<data[i].length;j++){
				//System.out.printf(data[i][j]);
			}
			System.out.println();
		}
	}
}
