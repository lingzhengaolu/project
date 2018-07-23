package com.company.utils.sql;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLConnection {
	public Connection getMysqlConnection(String driverclass,String url,String username,String password) {
		Connection connection=null;
		try {
			Class.forName(driverclass);
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			connection=DriverManager.getConnection(url,username,password);
		}catch (SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
	public MongoClient getMongoConnection(){
		MongoClient connection=null;
		ServerAddress serverAddress=new ServerAddress(SQLConfig.MongoUrl,SQLConfig.MongoPort);
		List<ServerAddress> address=new ArrayList<ServerAddress>();
		address.add(serverAddress);
		MongoCredential mongoCredential=MongoCredential.createScramSha1Credential(SQLConfig.MongoUsername,"admin",SQLConfig.MongoPassword.toCharArray());
		List<MongoCredential> credential=new ArrayList<MongoCredential>();
		credential.add(mongoCredential);
		connection=new MongoClient(address,credential);
		return connection;
	}
}
