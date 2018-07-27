package com.company.utils.sql;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLConnection {
	private Connection connection=null;
	private MongoClient mongoClient=null;
	public Connection getMysqlConnection() {
		try {
			Class.forName(SQLConfig.MysqlClass);
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			connection=DriverManager.getConnection(SQLConfig.MysqlUrl,SQLConfig.MysqlUsername,SQLConfig.MysqlPassword);
		}catch (SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
	public MongoClient getMongoConnection(){
		ServerAddress serverAddress=new ServerAddress(SQLConfig.MongoUrl,SQLConfig.MongoPort);
		List<ServerAddress> address=new ArrayList<ServerAddress>();
		address.add(serverAddress);
		MongoCredential mongoCredential=MongoCredential.createScramSha1Credential(SQLConfig.MongoUsername,"admin",SQLConfig.MongoPassword.toCharArray());
		List<MongoCredential> credential=new ArrayList<MongoCredential>();
		credential.add(mongoCredential);
		mongoClient=new MongoClient(address,credential);
		return mongoClient;
	}
	public void close(){
		if(connection!=null){
			try{
				connection.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		if(mongoClient!=null){
			mongoClient.close();
		}
	}

}
