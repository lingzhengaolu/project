package com.company.utils.sql;

import com.mongodb.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseOperations extends MysqlExecute{
    private String DBName;
    public DatabaseOperations(Connection connection){
        super(connection);
    }
    public DatabaseOperations(Connection connection,String DBName){
        super(connection);
        this.DBName=DBName;
        if(!isExist()){ create();}
    }
     boolean existenceDetection(String value){
        boolean flag=false;
        try{
            resultSet.next();
            if(value.equalsIgnoreCase(resultSet.getString(1))){
                flag=true;
            }else {
                flag=false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    ArrayList<String> returnList(String sql){
        ArrayList<String> arrayList=new ArrayList<>();
        executeQueryUtil(2,sql);
        try{
            while (resultSet.next()){
                arrayList.add(resultSet.getString(1));
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return arrayList;
    }
    public void getVersion(){
        //获取数据库版本
    }
    public void getCurrentUserName(){
        //获取当前登陆用户名
    }
    public void getServerIP(){
        //获取服务器ip
    }
    public void getClientIP(){
        //获取客户端ip
    }
    public ArrayList<String> getAllDBName(){
        //获取所有的数据库名称
        String sql="show databases";
        return returnList(sql);
    }
    public boolean isUsed(String DBName){
        //判断数据库是否被使用
        boolean flag=false;
        if(DBName.equalsIgnoreCase(getCurrentUseDBName())){
            flag=true;
        }
        return flag;
    }
    public boolean isUsed(){
        //判断数据库是否被使用
        boolean flag=false;
        if(DBName.equalsIgnoreCase(getCurrentUseDBName())){
            flag=true;
        }
        return flag;
    }
    public boolean isExist(String DBName){
        //判断数据库是否存在
        String sql="show databases like ?";
        executeQueryUtil(2,sql,DBName);
        return existenceDetection(DBName);
    }
    public boolean isExist(){
        //判断数据库是否存在
        String sql="show databases like ?";
        executeQueryUtil(2,sql,DBName);
        return existenceDetection(DBName);
    }
    public String getCurrentUseDBName(){
        //获取当前use 的库
        String database=null;
        String sql="select database()";
        executeQueryUtil(2,sql);
        try{
            resultSet.next();
            database=resultSet.getString(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return database;
    }
    public void use(String DBName){
        //usedb
        String sql="use "+DBName;
        executeUpdateUtil(2,sql);
    }
    public void use(){
        //usedb
        String sql="use "+DBName;
        executeUpdateUtil(2,sql);
    }
    public void drop(){
        //删库
    }
    public void drop(String DBName){
        //删库
    }
    public void create(String DBName){
        //建库
        String sql="create database if not exists "+DBName;
        executeUpdateUtil(2,sql);
    }
    public void create(){
        //建库
        String sql="create database if not exists "+DBName;
        executeUpdateUtil(2,sql);
    }
    public ResultSet getResultSet(){
        return resultSet;
    }
    public int getNum(){
        return number;
    }
    public boolean getFlag(){
        return flag;
    }
}
