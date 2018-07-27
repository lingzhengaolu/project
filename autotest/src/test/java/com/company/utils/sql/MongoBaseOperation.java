package com.company.utils.sql;

import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import net.sf.json.JSONObject;


public class MongoBaseOperation extends MongoDBCLOperation {
	public MongoBaseOperation(MongoClient connection,String dbName,String collectionName){
		super(connection);
		useDB(dbName);
		useCollection(collectionName);
	}
	public void insert(JSONObject jsonObject){
		DBObject dbObject=(DBObject)JSON.parse(jsonObject.toString());
		collection.insertOne(dbObject);
	}

}
