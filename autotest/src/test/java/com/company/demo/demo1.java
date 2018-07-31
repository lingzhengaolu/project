package com.company.demo;

import com.company.thread.CreateExcelDataSample;
import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

import java.util.HashMap;


public class demo1 {
	public static void main(String []args){
//		SQLConnection sqlConnection=new SQLConnection();
//		System.out.println(sqlConnection.getConnection(SQLConfig.MysqlUrl,SQLConfig.MysqlUsername,SQLConfig.MysqlPassword,SQLConfig.MysqlClass));
//		SelectFilePublic selectFilePublic=new SelectFilePublic();
//
//
//		System.out.println(selectFilePublic.PATH);
		//System.out.println(GetProjectInfo.ProjectPath);
		//ErrorDialog.errorDialog("标题","是hi hi i");
//		ArrayList<String> value=new ArrayList<String>();
//		for(int i=0;i<10;i++){
//			value.add(String.valueOf(i));
//		}
//		System.out.println(value);
//		SelectFilePublic selectFilePublic=new SelectFilePublic();
//		IOPublic ioPublic=new IOPublic(selectFilePublic.PATH);
//		ArrayList<String> arrayList=ioPublic.read();
//		for(String i:arrayList){
//			System.out.println(i);
//		}
//		Excel excel=new Excel(selectFilePublic.PATH,"sheet1");
//		String data[][]=excel.readExcel();
//		System.out.println(excel.getColoumNum());
//		System.out.println(excel.getRowNum());
//		for(int i=0;i<data.length;i++){
//			for(int j=0;j<data[i].length;j++){
//				System.out.printf(data[i][j]+"\t");
//			}
//			System.out.println();
//		}
//		System.out.println(excel.getColoumNum());
//		System.out.println(excel.getRowNum());
//		String[][] a=new String[][]{{"1","2","311111111111111111111111111111111111111111111","4"},{"1","2","3","4"}};
//		System.out.println(a.length);
//		System.out.println(a[0].length);
//		Excel excel=new Excel("D:\\78.xl","开幕式");
//		excel.createExcel(a);
//		SQLConnection sqlConnection=new SQLConnection();
//		Connection connection=sqlConnection.getConnection(SQLConfig.MysqlClass,SQLConfig.MysqlUrl,SQLConfig.MysqlUsername,SQLConfig.MysqlPassword);
//		MysqlCreate mySqlCreate =new MysqlCreate(connection);
//		for(int i=0;i<1000;i++){
//			mySqlCreate.createDataBase("kms1");
//			System.out.println(mySqlCreate.getFlag());
//			mySqlCreate.useDataBase("kms1");
//			System.out.println(mySqlCreate.getFlag());
//			mySqlCreate.createTable("kms");
//			System.out.println(mySqlCreate.getFlag());
//
//		}
//		mySqlCreate.closeStmt();
//		mySqlCreate.closeConnection();
		//s1(1,2,1,2,3);
//		ArrayIndexOf arrayIndexOf=new ArrayIndexOf();
//		String[] a=new String[]{"1","2","10","8","2"};
//		System.out.println(arrayIndexOf.arrayIndex(a,"2"));
////		ErrorDialog.errorDialog("数据检查","二维数组字段名错误，请检查！" +
////				"目标字段名：controlCode,controlName,eleRecMethod,eleRoute,timeOut");
//		int[][] c=new int[][]{{1,2,3},{5,6,3}};
//		SelectFilePublic selectFilePublic=new SelectFilePublic();
//		Excel excel=new Excel(selectFilePublic.PATH,"sheet1");
//		String[][] data=excel.readExcel();
//		Print.printArray(data);
//		String dbn="ty006";
//		SQLConnection sqlConnection=new SQLConnection();
//		Connection connection=sqlConnection.getMysqlConnection();
//
//
//		new MysqlCreate(connection).useDataBase(dbn);
//		MysqlSelect mysqlSelect=new MysqlSelect(connection);

//System.out.println("ty006".equalsIgnoreCase(mysqlSelect.getCurrentUsedDatabase()));
		//ResultSet resultSet=mysqlSelect.selectElement("login");
//		ResultSet resultSet1=mysqlSelect.selectCasedata("1");
//		System.out.println(mysqlSelect.getValue(resultSet1,"group"));
//		ResultSet resultSet2=mysqlSelect.selectCountAll("login");

//		HashMap<String,LocatorE> eleinfos=ElementDataProcessing.readElementInfo(mysqlSelect,"login");
//		System.out.println(eleinfos.get("14").getEleRoute());
//
//		System.out.println(TestCaseDataProcessing.getTestCaseData(mysqlSelect,"13").getTestcase());
//		System.out.println(TestCaseDataProcessing.getTestCaseData(mysqlSelect,"13").getExpectedResults());
//		mysqlCreate.createTableE("login");
//		mysqlCreate.createTableE("mainPage");
//		mysqlCreate.createTableC();
//		System.out.println(new ReadJSON("{'78':'89','85':'87'}").getValue("8"));
//		System.out.println("89xx");




//
//
//
//		String[][] excel1=new Excel("D:\\xxxxxxxxxxx.xls","sheet1").readExcel();
//		String[][] excel2=new Excel("D:\\yyyyyyyyyy.xls","sheet1").readExcel();
//		MysqlInsert mysqlInsert=new MysqlInsert(connection);
//		mysqlInsert.insertElement("login",excel1);
//		mysqlInsert.insertElement("mainPage",excel1);
//		mysqlInsert.insertCase(excel2);

//		MysqlUpdate mysqlUpdate=new MysqlUpdate(connection);
//		mysqlUpdate.updateElement("login",excel1);
//		mysqlUpdate.updateCaseData(excel2);

//
//		mysqlSelect.closestmt();
//		mysqlSelect.closeConnection();

//System.out.println(GetProjectInfo.ProjectName);



//		new CreateFolder().autoCreate();
//		System.out.println(GetProjectInfo.ProjectPath);
//		new CreateExcelSample().createCasedataExSample();
//		new CreateExcelSample().createPageExSample();
//		MysqlInsert mysqlInsert=new MysqlInsert(connection);
//		mysqlInsert.insertElement("lzs",data);
//		mysqlInsert.closePstmt();
//		mysqlInsert.closeConnection();

//		SQLConnection sqlConnection=new SQLConnection();
//		MongoClient mongoConnection=sqlConnection.getMongoConnection();
//		MongoDBCLOperation mongoBaseOperation=new MongoDBCLOperation(mongoConnection);
//		mongoBaseOperation.useDB("opl");
//		CreateJSON createJSON=new CreateJSON(data);
//		ArrayList<JSONObject> jsonObjects=createJSON.createJSON();
//		MongoBaseOperation mongoBaseOperation=new MongoBaseOperation(mongoConnection,"kmssss","kmsd");
//		for(JSONObject i:jsonObjects){
//			System.out.println(i);
//			mongoBaseOperation.insert(i);
//
//		}
//		mongoBaseOperation.close();
//		GetProjectInfo getFileNamePublic=new GetProjectInfo();
//		for(String i:getFileNamePublic.getFileNameList("D:\\project\\autotest\\src\\test\\java\\com\\company\\uiframework")){
//			System.out.println(i);
//		}
		//new CodeInputDialog().inputDialog();
//		new CreateExcelDataSample();
//		int s=10;
//		HashMap<String,Object> hashMap=new HashMap<>();
//		String expre="i=s+9";
//		hashMap.put("s",s);
//		JexlContext code=convertToCode(expre,hashMap);
//		System.out.println(code.get("i"));

		String i=null;
		System.out.println(i.length());










	}
//	static void s1(int i,int j,int ... k){
//		System.out.println(i);
//		System.out.println(j);
//		System.out.println(k);
	public static JexlContext convertToCode(String jexlExp,HashMap<String,Object> hashMap){
		JexlEngine jexlEngine=new JexlEngine();
		Expression expression=jexlEngine.createExpression(jexlExp);
		JexlContext jexlContext=new MapContext();
		for(String key:hashMap.keySet()){
			jexlContext.set(key,hashMap.get(key));
		}
		return jexlContext;

	}
//	}


}
