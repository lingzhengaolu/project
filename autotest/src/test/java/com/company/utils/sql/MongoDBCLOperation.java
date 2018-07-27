package com.company.utils.sql;


import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

class MongoDBCLOperation {
	MongoClient connection=null;
	MongoDatabase mongoDatabase=null;
	MongoCollection collection=null;
	MongoDBCLOperation(MongoClient connection){
		this.connection=connection;
	}
	void useDB(String DBName){
		mongoDatabase=connection.getDatabase(DBName);
	}
	void useCollection(String collectionName){
		collection=mongoDatabase.getCollection(collectionName,DBObject.class);
	}


	public void close(){
		if(mongoDatabase!=null){
			mongoDatabase=null;
		}
		if(connection!=null){
			connection.close();
		}
	}
}
