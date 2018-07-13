package com.company.utils.excel;

import com.company.utils.SelectFilePublic;

import java.io.File;

public class GetExcelFile {
	public String filepath;
	public GetExcelFile(String filepath){
		this.filepath=filepath;
	}
	public GetExcelFile(){
		SelectFilePublic selectFilePublic=new SelectFilePublic();
		this.filepath=selectFilePublic.PATH;
	}
	public File getExcelFile(){
		return (new File(filepath));
	}

}
