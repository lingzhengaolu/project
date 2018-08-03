package com.company.testcases.pub;

import com.company.thread.CreateFolder;
import org.testng.annotations.BeforeClass;

public class PreProcessors {
	//前置处理器
	/*
		本地环境检测
		本地数据检测
		连接数据库
		数据库检测
		数据库table检测
		数据插入或更新
		更新情况反馈到excel，并清除操作类型
	*/
	@BeforeClass
	public void projectPreCheck(){
		CreateFolder.autoCreate();

	}

}
