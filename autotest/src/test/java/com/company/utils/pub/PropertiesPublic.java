package com.company.utils.pub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesPublic {
    private static Properties properties=null;
    private static String propertiesFileName;
    public PropertiesPublic(String fileName){
        this.propertiesFileName=fileName;
    }

    public String getPropertiesValue(String keyName){
        properties=new Properties();
        InputStream in = PropertiesPublic.class.getClassLoader().getResourceAsStream(propertiesFileName);
        InputStreamReader isr;
        String value=null;
        try{
            isr=new InputStreamReader(in,"gbk");
            BufferedReader br=new BufferedReader(isr);
            properties.load(br);
            value=properties.getProperty(keyName).trim();
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        if(keyName.contains("driverpath")){
            value=GetProjectInfo.ProjectPath+value;
        }
        return value;
    }
}
