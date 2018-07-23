package com.company.utils.sql;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoBaseOperation {
	MongoClient connection;
	MongoDatabase mongoDatabase=null;
	public MongoBaseOperation(MongoClient connection,String DBName){
		this.connection=connection;
		this.mongoDatabase=connection.getDatabase(DBName);
	}
	public void getMongoDatabase(String DBName){
		mongoDatabase=connection.getDatabase(DBName);
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
