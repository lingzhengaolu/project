package com.company.uiframework;

public class LocatorE {
	/*
	控件唯一识别码：controlCode
	控件名称：controlName
	元素识别方式：eleRecMethod
	元素路径：eleRoute
	显式等待时长：timeOut
	*/
	private String controlCode;
	private String controlName;
	private String eleRecMethod;
	private String eleRoute;
	private int timeOut;

	public LocatorE(String controlCode, String controlName, String eleRecMethod, String eleRoute, int timeOut){
		this.controlCode=controlCode;
		this.controlName=controlName;
		this.eleRecMethod=eleRecMethod;
		this.eleRoute=eleRoute;
		this.timeOut=timeOut;
	}
	public String getControlCode(){
		return controlCode;
	}
	public String getControlName(){
		return controlName;
	}
	public String getEleRecMethod(){
		return eleRecMethod;
	}
	public String getEleRoute(){
		return eleRoute;
	}
	public void setEleRoute(String eleRoute){
		this.eleRoute=eleRoute;
	}
	public int getTimeOut(){
		return timeOut;
	}
}
