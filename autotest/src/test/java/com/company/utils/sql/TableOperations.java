package com.company.utils.sql;

import java.sql.Connection;
import java.util.ArrayList;

public class TableOperations extends DatabaseOperations{
    private String tableName;
    public TableOperations(Connection connection,String DBName){
        super(connection,DBName);
        if(!super.isUsed()){ use(DBName);}
    }
    public TableOperations(Connection connection,String DBName,String tableName){
        super(connection,DBName);
        if(!isUsed()){ use(DBName);}
        this.tableName=tableName;
    }
    public ArrayList<String> getAllTableName(){
        String sql="show tables";
        return returnList(sql);
    }
    public boolean isExist(){
        //重写判断table是否存在
        String sql="show tables like ?";
        executeQueryUtil(2,sql,tableName);
        return existenceDetection(tableName);
    }
    public boolean isExist(String tableName){
        //重写判断table是否存在
        String sql="show tables like ?";
        executeQueryUtil(2,sql,tableName);
        return existenceDetection(tableName);
    }

    public void create(String tableName,String sql){
        //建表


    }
    public void create(String sql){
        //建表


    }
    public void drop(String tableName){
        //重写 删表

    }
    public void drop(){
        //重写 删表

    }
    public void delete(String tableName){
        //删除表数据,不删除表结构

    }
    private String returnStr(ArrayList<String> value){
        String str="";
        for(String i:value){
            str=str+i+",";
        }
        str=str.substring(0,str.length()-1);
        return str;
    }
    private String returnStr(String[] value){
        String str="";
        for(String i:value){
            str=str+i+",";
        }
        str=str.substring(0,str.length()-1);
        return str;
    }
    public void select(){
        String sql="select * from "+tableName;
    }
    public void select(String tableName){
        String sql="select * from "+tableName;
    }
    public void select(ArrayList<String> filed){
        String sql="select "+returnStr(filed)+" "+tableName;
    }
    public void select(String tableName,ArrayList<String> filed){
        String sql="select "+returnStr(filed)+" "+tableName;
    }
    public void select(String[] filed){
        String sql="select "+returnStr(filed)+" "+tableName;
    }
    public void select(String tableName,String[] filed){
        String sql="select "+returnStr(filed)+" "+tableName;
    }

    public void update(ArrayList<String> filed){

    }
    public void update(String tableName,ArrayList<String> filed){

    }

    public void update(String[] filed){

    }
    public void update(String tableName,String[] filed){
        
    }


    public void insert(){

    }




}
