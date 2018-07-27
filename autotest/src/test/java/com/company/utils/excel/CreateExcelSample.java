package com.company.utils.excel;

import com.company.utils.pub.GetProjectInfo;

public class CreateExcelSample {
	private ExcelField excelField=new ExcelField();
	public void createPageExSample(){
		new Excel(GetProjectInfo.ProjectPath+"\\sample\\"+"pageSample.xls","sheet1").createExcel(excelField.elementField());
		new Excel(GetProjectInfo.ProjectPath+"\\sample\\"+"pageSample.xlsx","sheet1").createExcel(excelField.elementField());
	}
	public void createCasedataExSample(){
		new Excel(GetProjectInfo.ProjectPath+"\\sample\\"+"casedataSample.xls","sheet1").createExcel(excelField.casedataField());
		new Excel(GetProjectInfo.ProjectPath+"\\sample\\"+"casedataSample.xlsx","sheet1").createExcel(excelField.casedataField());
	}
}
