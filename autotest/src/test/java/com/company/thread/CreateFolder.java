package com.company.thread;

import com.company.utils.pub.GetProjectInfo;

import java.io.File;

public class CreateFolder {
	public void autoCreate(){
		String[] folderList=new String[]{
				"log",
				"elementdata",
				"sample",
				"webdrivers",
				"testcasedata"
		};
		for(String i:folderList){
			File file=new File(GetProjectInfo.ProjectPath+"\\"+i);
			file.mkdirs();
		}
	}
}
