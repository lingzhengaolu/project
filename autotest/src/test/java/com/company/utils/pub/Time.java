package com.company.utils.pub;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {
	private SimpleDateFormat tempDate;
	private Calendar calendar;
	private String nowTime;
	public Time(String format){
		tempDate=new SimpleDateFormat(TimeFormat.getTimeFormat(format));
		calendar=Calendar.getInstance();
		nowTime=tempDate.format(new Date(System.currentTimeMillis()));
	}
	public Time(){
		tempDate=new SimpleDateFormat(TimeFormat.getTimeFormat("ymdhms"));
		calendar=Calendar.getInstance();
		nowTime=tempDate.format(new Date(System.currentTimeMillis()));
	}
    public String getNowTime(){
		return nowTime;
	}
	public int getYear(){
		return calendar.get(Calendar.YEAR);
	}
	public int getMonth(){
		return calendar.get(Calendar.MONTH);
	}
	public int getDay(){
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	public int getHour(){
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	public int getMinute(){
		return calendar.get(Calendar.MINUTE);
	}
	public int getSecond(){
		return calendar.get(Calendar.SECOND);
	}
	public long getMilliSecond(){
		return calendar.getTimeInMillis();
	}
	public long getCurrentTimeMillis(){
		return System.currentTimeMillis();
	}
	public long dateToStamp(String time){
		long stamp=0L;
		try{
			stamp=((new SimpleDateFormat(TimeFormat.getTimeFormat("ymdhms"))).parse(time)).getTime();
		}catch (ParseException e){
			e.printStackTrace();
		}
		return stamp;
	}
}
