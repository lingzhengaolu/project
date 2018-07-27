package com.company.utils.pub;


import net.sf.json.JSONObject;

public class ReadJSON {
	private String json;
	public ReadJSON(String json){
		this.json=json;
	}
	public String getValue(String key){
		JSONObject jsonObject=JSONObject.fromObject(json);
		return jsonObject.getString(key);
	}
}
