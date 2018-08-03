package com.company.testcases.pub;

public class LocatorC {
	private String id;
	private String group;
	private String testcase;
	private String expectedResults;
	public LocatorC(String id,String group,String testcase,String expectedResults){
		this.id=id;
		this.group=group;
		this.testcase=testcase;
		this.expectedResults=expectedResults;
	}
	public String getId(){
		return id;
	}
	public String getGroup(){
		return group;
	}
	public String getTestcase(){
		return testcase;
	}
	public String getExpectedResults(){
		return expectedResults;
	}
}
