package com.company.utils.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

//Excel类数据写入效率低，但是数据写入属于实时写入，实时写入，实时保存
public class Excel {
	private String path;
	private String sheetName;
	private FileInputStream fileInputStream=null;
	private FileOutputStream fileOutputStream=null;
	private Workbook workbook=null;
	private Sheet sheet=null;
	public Excel(String path,String sheetName){
		this.path=path;
		this.sheetName=sheetName;
	}
	private File getExcelFile(){
		File file=new File(path);
		return file;
	}
	public int getColoumNum(){
		//获取列数
		int coloumNum=sheet.getRow(0).getPhysicalNumberOfCells();
		return coloumNum;
	}
	public int getRowNum(){
		//获取总行数
		int rowNum=sheet.getLastRowNum()+1;
		return rowNum;
	}
	private void getSheet(){
		try{
			fileInputStream=new FileInputStream(getExcelFile());
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			if(path.endsWith(".xls")){
				workbook=new HSSFWorkbook(fileInputStream);
			}else if(path.endsWith(".xlsx")){
				workbook=new XSSFWorkbook(fileInputStream);
			}else {
				System.out.println("文件格式错误，非标准的excel文件！");
				System.exit(0);
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
	}
	public String[][] readExcel(){
		getSheet();
		int rowNum=getRowNum();
		int coloumNum=getColoumNum();
		String[][] data=new String[rowNum][coloumNum];
		for(int i=0;i<rowNum;i++){
			for(int j=0;j<coloumNum;j++){
				Row row=sheet.getRow(i);
				Cell cell=row.getCell(j);
				if(cell==null){
					data[i][j]="";
				}else {
					cell.setCellType(Cell.CELL_TYPE_STRING);//强制转换为String
					data[i][j]=cell.getStringCellValue().trim();
					if(data[i][j].length()==0||"null".equalsIgnoreCase(data[i][j])){
						data[i][j]="";
					}
				}
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
	public void updateExcel(int rowIndex,int cellIndex,String value){
		getSheet();
		try {
			fileInputStream.close();//关闭输入流后，开始文件输出流
		}catch (IOException e){
			e.printStackTrace();
		}
		Row row=sheet.getRow(rowIndex);
		Cell cell=row.getCell(cellIndex);
		cell.setCellValue(value);
		Public();
	}

	public void createExcel(String[][] value){
		if(path.endsWith(".xls")){
			workbook=new HSSFWorkbook();
		}else if(path.endsWith(".xlsx")){
			workbook=new XSSFWorkbook();//创建新的工作簿
		}else {
			System.out.println("文件格式错误，非标准的excel文件！");
			System.exit(0);
		}
		sheet=workbook.createSheet(sheetName);
		int rowNum=value.length;
		int cellNum=value[0].length;
		for (int i=0;i<rowNum;i++){
			Row row=sheet.createRow(i);
			for (int j=0;j<cellNum;j++){
				row.createCell(j).setCellValue(value[i][j]);
			}
		}
		Public();
	}
	private void Public(){
		try {
			fileOutputStream=new FileOutputStream(getExcelFile());//开始输出流
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		try {
			workbook.write(fileOutputStream);//写入输出流
		}catch (IOException e){
			e.printStackTrace();
		}
		try{
			workbook.close();//关闭工作空间
		}catch (IOException e){
			e.printStackTrace();
		}
		try{
			fileOutputStream.flush();//提交
		}catch (IOException e){
			e.printStackTrace();
		}
		try {
			fileOutputStream.close();
		}catch (IOException e){
			e.printStackTrace();//关闭输出流
		}
	}
}
