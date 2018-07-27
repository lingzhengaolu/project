package com.company.utils.pub;


import java.io.File;

public class GetProjectInfo {
	public static final String ProjectPath=System.getProperty("user.dir");//获取项目路径
	public static final String ProjectName=new File(ProjectPath).getName();
}
