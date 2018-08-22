package com.company.utils.excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

//Excel2类提高数据传输的效率，数据不及时写入excel文件
//只提供数据写入方法，数据读取方法由Excel类提供
public class Excel2 {
	private String path;
	private String sheetName;
	private FileInputStream fileInputStream=null;
	private FileOutputStream fileOutputStream=null;
	private Workbook workbook=null;
	private Sheet sheet=null;

}
