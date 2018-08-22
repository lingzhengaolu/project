package com.company.utils.sql;

import java.sql.Connection;
import java.util.ArrayList;

public class TableOperations extends DatabaseOperations{
    private String tableName;
    public TableOperations(Connection connection,String DBName){
        super(connection,DBName);//db被使用则create
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

    public void create(String sql){
        //建表
        executeUpdateUtil(2,sql);

    }

    public void drop(String tableName){
        //重写 删表
        String sql="drop table "+tableName;
        executeUpdateUtil(2,sql);

    }
    public void drop(){
        //重写 删表
        String sql="drop table "+tableName;
        executeUpdateUtil(2,sql);

    }

    public void truncate(){
        //清空表格data
        String sql="truncate table "+tableName;
        executeUpdateUtil(2,sql);

    }
    public void truncate(String tableName){
        //情空表格 重载
        String sql="truncate table "+tableName;
        executeUpdateUtil(2,sql);

    }

    public void delete(String sql){
        //删除表数据,不删除表结构
        executeUpdateUtil(2,sql);

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
        executeUpdateUtil(2,sql);

    }
    public void select(String tableName){
        String sql="select * from "+tableName;
        executeUpdateUtil(2,sql);

    }
    public void select(ArrayList<String> filed){
        String sql="select "+returnStr(filed)+" "+tableName;
        executeUpdateUtil(2,sql);

    }
    public void select(String tableName,ArrayList<String> filed){
        String sql="select "+returnStr(filed)+" "+tableName;
        executeUpdateUtil(2,sql);

    }
    public void select(String[] filed){
        String sql="select "+returnStr(filed)+" "+tableName;
        executeUpdateUtil(2,sql);

    }
    public void select(String tableName,String[] filed){
        String sql="select "+returnStr(filed)+" "+tableName;
        executeUpdateUtil(2,sql);
    }

    public void update(String sql,String ... value){
        //语法太过复杂不写通用架构
        executeUpdateUtil(2,sql,value);

    }

    public void insert(String sql,String ...value){
        //插入语句，语法结果复杂，后续处理，demo中
        executeUpdateUtil(2,sql,value);
    }




}
