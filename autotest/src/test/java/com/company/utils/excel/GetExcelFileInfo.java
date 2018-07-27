package com.company.utils.excel;

import com.company.utils.pub.GetProjectInfo;

import java.io.File;
import java.util.ArrayList;

public class GetExcelFileInfo {
	public String elementDataPath=GetProjectInfo.ProjectPath+"\\elementdata\\";
	public String casedataPath=GetProjectInfo.ProjectPath+"\\testcasedata\\";
	private String[] getFileNameList(String folderPath){
		File file=new File(folderPath);
		String[] files=file.list();
		return files;
	}
	public ArrayList<String> getElementFileName(){
		String[] value=getFileNameList(elementDataPath);
		ArrayList<String> arrayList=new ArrayList<>();
		for(String i:value){
			if(i.endsWith(".xlsx")||i.endsWith(".xls")){
				arrayList.add(i);
			}
		}
		return arrayList;
	}
	public ArrayList<String> getCasedataFileName(){
		String[] value=getFileNameList(casedataPath);
		ArrayList<String> arrayList=new ArrayList<>();
		for(String i:value){
			if(i.endsWith(".xlsx")||i.endsWith(".xls")){
				arrayList.add(i);
			}
		}
		return arrayList;
	}
}
