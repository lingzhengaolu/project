package com.company.utils.pub;

import org.json.JSONObject;
import org.json.JSONString;

import java.util.ArrayList;

public class CreateJSON {
	public String[][] value=null;
	public CreateJSON(String[][] value){
		this.value=value;
	}
	public ArrayList<JSONObject> createJSON(){
		String[] field=value[0];
		ArrayList<JSONObject> arrayList=new ArrayList<JSONObject>();
		int row=value.length;
		int cell=field.length;
		for(int i=1;i<row;i++){
			JSONObject jsonObject=new JSONObject();
			for(int j=0;j<cell;j++){
				if(value[i][j]!=null&&value[i][j].length()>0){
					jsonObject.put(field[j],value[i][j]);
				}
			}
			arrayList.add(jsonObject);
		}
		return arrayList;
	}
}
