package com.company.utils.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Excel {
	private File getExcelFile(String path){
		File file=new File(path);
		return file;
	}
	public int getColoumNum(Sheet sheet){
		//获取列数
		int coloumNum=sheet.getRow(0).getPhysicalNumberOfCells();
		return coloumNum;
	}
	public int getRowNum(Sheet sheet){
		//获取总行数
		int rowNum=sheet.getLastRowNum()+1;
		return rowNum;
	}
	public int[] getSize(Sheet sheet){
		int[] size=new int[]{getRowNum(sheet),getColoumNum(sheet)};
		return size;
	}
	public String[][] readExcel(String path,String sheetName){
		FileInputStream fileInputStream=null;
		Workbook workbook=null;
		try{
			fileInputStream=new FileInputStream(getExcelFile(path));
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			if(path.endsWith(".xls")){
				workbook=new HSSFWorkbook(fileInputStream);
			}else if(path.endsWith(".xlsx")){
				workbook=new XSSFWorkbook(fileInputStream);
			}else {
				System.out.println("文件格式错误！非标准的excel文件");
				return null;
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		Sheet sheet=workbook.getSheet(sheetName);
		int rowNum=getRowNum(sheet);
		int coloumNum=getColoumNum(sheet);
		String[][] data=new String[rowNum][coloumNum];
		for(int i=0;i<rowNum;i++){
			for(int j=0;j<coloumNum;j++){
				Row row=sheet.getRow(i);
				Cell cell=row.getCell(j);
				cell.setCellType(Cell.CELL_TYPE_STRING);//强制转换为String
				data[i][j]=cell.getStringCellValue().trim();
			}
		}
		try{
			workbook.close();
		}catch (IOException e){
			e.printStackTrace();
		}
		try {
			fileInputStream.close();
		}catch (IOException e){
			e.printStackTrace();
		}
		return data;
	}
}
