package com.company.utils.pub;

import net.sf.json.JSONObject;

public class CreateJSON {
	private String[][] value;
	private String[] field;
	private int cell;
	public CreateJSON(String[][] value){
		this.value=value;
		this.field=value[0];
		this.cell=field.length;
	}
	public JSONObject createJson(String[] array){
		JSONObject jsonObject=new JSONObject();
		for(int j=0;j<cell;j++){
			if(
					array[j]!=null&&array[j].length()>0&&
					!field[j].equalsIgnoreCase("id")&&
					!field[j].equalsIgnoreCase("group")&&
					!field[j].equalsIgnoreCase("expectedResults")&&
					!field[j].equalsIgnoreCase("actualResults")&&
					!field[j].equalsIgnoreCase("testResults")&&
					!field[j].equalsIgnoreCase("remarks")&&
					!field[j].equalsIgnoreCase("feedbackResults")&&
					!field[j].equalsIgnoreCase("taskType")){
				jsonObject.put(field[j],array[j]);
			}
		}
		return jsonObject;
	}
}
