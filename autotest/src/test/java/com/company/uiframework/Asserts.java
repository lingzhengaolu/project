package com.company.uiframework;

import org.testng.Assert;

public class Asserts {
	public void checkIntNum(int actual,int expected,String ... message){
		Assert.assertEquals(actual, expected);
	}
	//字符串型比较断言
	public void checkString(String actual,String expected,String ... message){
		Assert.assertEquals(actual, expected);
	}
	//字符串包含断言
	public void checkStringContains(String actual,String expected,String ... message){
		Assert.assertEquals(true,actual.contains(expected));
	}
	//非空断言
	public void checkNotNull(Object actual,String ... message){
		Assert.assertNotNull(actual);
	}
}
