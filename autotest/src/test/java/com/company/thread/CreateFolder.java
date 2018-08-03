package com.company.thread;

import com.company.utils.pub.GetProjectInfo;

import java.io.File;

public class CreateFolder {
	private static String[] folderList=new String[]{
			"log",
			"elementdata",
			"sample",
			"webdrivers",
			"testcasedata"
	};
	public static void autoCreate(){
		for(String i:folderList){
			File file=new File(GetProjectInfo.ProjectPath+"\\"+i);
			file.mkdirs();
		}
	}
}
